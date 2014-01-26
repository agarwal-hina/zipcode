/** Global variable to calculate data on client side or server side */
var isServerSide = true;

$(document).ready(function() {
    bindClickEvent();
});
/**
 * This API bind the click event of input button. On the basis of isServerSide flag, it will invoke the method
 * whether to validate and retrieve data on client side or server side.
 */
function bindClickEvent() {
    $("#submitForm").bind('click', function() {
        $("#submitForm").unbind("click");
        if (isServerSide) {
            serverSide();
        } else {
            cliendSide();
        }
    });
};
/**
 * This method will post the form and do the validation on client side. If validation fails, then it will show the error
 * on top otherwise it will show the table with details.
 */
function serverSide() {
    var url ="weatherdetails";
    $("#loadingImageDivId").css('display','block');
    $.ajax({
        type : "POST",
        url : url,
        data : $("#countryForm").serialize(),
        success : function(data) {
            
            $("#mainDiv").html(data);
            var error = $("#errorMessage")[0];
            if (error == undefined) {
                $("#weatherDetails").css('display', 'block');
            }
            $("#loadingImageDivId").css('display','none');
        },
        dataType : "html"
    });
};

/**
 * This method will validate on client side. If validation fails, then it will show the error
 * on top otherwise it will show the table with details retrieve data from jsonp.
 */
function cliendSide() {
    $("#loadingImageDivId").css('display','block');
    var zipCode = $("#zipcode").val();
    if (validateZIPCode(zipCode)) {
        var url = "http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/" + zipCode + ".json";
        $.ajax({
            url : url,
            dataType : "jsonp",
            success : function(parsed_json) {
                $("#clientSideErrorMsg").css('display','none');
                var error = parsed_json['response']['error'];
                if (error == null || error == '') {
                    var city_name = parsed_json['current_observation']['display_location']['city'];
                    var state_name = parsed_json['current_observation']['display_location']['state_name'];
                    var temp_f = parsed_json['current_observation']['temp_f'];
                    var tBodyStr = "<tr><td>" + city_name + "</td><td>" + state_name + "</td><td>" + temp_f
                            + "</td></tr>";
                    $("#weatherDetails").css('display', 'block');
                    $("#tableBody").html(tBodyStr);
                    
                } else {                   
                    $("#weatherDetails").css('display', 'none');
                    $("#clientSideErrorMsg").html("<ul><li>zip code not found</li></ul>");
                    $("#clientSideErrorMsg").css('display', 'block');
                }
            },
            complete : function() {
                $("#loadingImageDivId").css('display','none');
                bindClickEvent();
            }
        });
    } else {
        $("#weatherDetails").css('display', 'none');
        $("#loadingImageDivId").css('display','none');
        $("#clientSideErrorMsg").html("<ul><li>invalid zip code format</li></ul>");
        $("#clientSideErrorMsg").css('display', 'block');
        bindClickEvent();
    }
    
    /**
     * This method validate the ZIP code in client side
     * */
    function validateZIPCode(zipCode) {
        
        var isValid = true;
        if (zipCode == null || zipCode == '') {
            isValid = false;
        } else {
            if (zipCode.length != 5 && !$.isNumeric(zipCode)) {
                isValid = false;
                ;
            }
        }
        return isValid;
    }
    ;
}