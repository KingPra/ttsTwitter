$(document).ready(function() {
    $('.unfollo_btn').hover(funciton() {
        $(this).removeClass('btn-primary');
        $(this).addClass('btn-danger');
        $(this).html("Unfollow");
    }, function() {
        $(this).html("Following");
        $(this).removeClass('btn-danger');
        $(this).addClass('btn-primary');
    });
})