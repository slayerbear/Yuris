

var show = true;

function myFunction(idx) {

    console.log(idx);

    $.ajax({
        url : 'updatebook?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType : 'json',
        data : JSON.stringify(idx),
        success : function (res) {
            $('#bookNumber').val(res.number);
            $('#bookArrivalAuthor').val(res.departureAuthor);
            $('#bookDepartureAuthor').val(res.arrivalAuthor);
        }
    })




   var popup = document.getElementById('myPopup');

    if(show){
        popup.classList.toggle('show');
        show = false;
    }
}

$('saveUpdate').click(function () {
    document.getElementById('myPopup').classList.toggle('hide');
})