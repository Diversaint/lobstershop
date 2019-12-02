<script type="text/javascript">
    $(document).ready(function(){
        var user;
        var userToken;
        var messageRespone;
        var wordToLearned = {};
        var dictionary;
        var linkToImg;
        /**
         * auto changing background
         */
        var body = $('body');
        // todo load locally

        var current = 0;
        /**
         * supporting func
         */
        function checkPass(){
            var pass1 = $('#password');
            var passConfirm = $('#passwordConfirm');
            var message = $('#confirmMessage');
            var goodColor = "#66cc66";
            var badColor = "#ff6666";
            if(pass1.val() == passConfirm.val() && pass1.val().length > 4 && pass1.val().length < 12){
                passConfirm.css("background-color", goodColor);
                message.css("color", goodColor);
                message.text("Passwords Match");
                return true;
            }else{
                passConfirm.css("background-color", badColor);
                message.css("color", badColor);
                message.text("Passwords Do Not Match!");
                return false;
            }
        };
        function emailValidate(){
            var regMail = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
            var email = this.value;
            if(regMail.test(email))
            {
                $('#statusEmail').text("Thanks, you have entered a valid Email address!")
                return true;
            }
            else
            {
                $('#statusEmail').text("Email address is not valid yet.")
                return false;
            }
        }


        $('#passwordConfirm').keyup(checkPass);
        $('#email').change(emailValidate);

        $('#btnLog').click(function () {
            user = null;
            location.reload();
        })

    });
</script>
