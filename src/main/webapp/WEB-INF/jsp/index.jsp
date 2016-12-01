<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

</head>
<body>
<script>

    $(document).ready(function () {

        $('#send').on('click', function () {

            $.ajax({
                headers: {
                    'Content-Type': 'application/json'
                },
                type: 'POST',
                url: 'equation',
                data: JSON.stringify({
                    'paramA': 0.001,
                    'paramB': 0.001,
                    'paramC': 0.001
                }),
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    alert('Oops, something WRONG happened. :(');
                }
            });

        });

    });

</script>
<button id="send">send</button>
</body>
</html>
