$(document).ready(function() {	
	
	findRole();
	findActive();
	bindEventCheckAllCheckBox('checkAll');
	 enableOrDisableDeleteAll();
	 autoCheckCheckboxAll('checkAll');
	 
});
function getFullNameText(){
	$('#fullName').on("change", function () {
		  alert($(this).val());
		});
}
function enableOrDisableDeleteAll() {
    $('input[type=checkbox]').click(function () {
        if ($(this).attr('id') == 'checkAll' && $(this).prop('checked') == false) {
            $(this).closest('table').find('input[type=checkbox]').prop('checked', false);
        }
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#deleteAll').prop('disabled', false);
        } else {
            $('#deleteAll').prop('disabled', true);
        }
    });
}
function autoCheckCheckboxAll(id) {
    var totalCheckbox = $('#' +id).closest('table').find('tbody input[type=checkbox]').length;
    $('#' +id).closest('table').find('tbody input[type=checkbox]').each(function () {
         var tableObj = $('#' +id).closest('table');
         $(this).on('change', function () {
                var totalCheckboxChecked = $(tableObj).find('tbody input[type=checkbox]:checked').length;
                if (totalCheckboxChecked == totalCheckbox) {
                   $('#' +id).prop('checked', true);
                } else {
                   $('#' +id).prop('checked', false);
                }
         });
    });
}
 
function bindEventCheckAllCheckBox(id) {
    $('#' + id).on('change', function () {
        if ((this).checked) {
            //enable all checkbox
            $(this).closest('table').find('input[type=checkbox]').prop('checked', true);
        } else {
            //disable all checkbox
            $(this).closest('table').find('input[type=checkbox]').prop('checked', false);
        }
    });
}

function findRole() {
	$("#tableList .roleCheckbox").each(function() {
		var texttocheck = $(this).html();
		if (texttocheck == "true") {
			trueAdmin($(this)) ;
		} else {
			falseAdmin($(this)) ;
		}
	});
}

function findActive() {
	$("#tableList .activeCheckbox").each(function() {
		var texttocheck = $(this).html();
		if (texttocheck == "true") {
			activeRole($(this)) ;
		} else {
			inactiveRole($(this)) ;
		}
	});
}

function activeRole(self) {
	var text1 = "<span class='badge badge-pill badge-success'>Active</span>";
	
	self.html(text1);
}

function inactiveRole(self) {
	var text1 = "<span class='badge badge-pill badge-secondary'>Disabled</span>";
		self.html(text1);
}


function trueAdmin(self) {
	var text1 = "<span class='badge badge-pill badge-danger'>Admin</span>";
	
	self.html(text1);
}

function falseAdmin(self) {
	var text1 = "<span class='badge badge-pill badge-light'>User</span>";
		self.html(text1);
}
