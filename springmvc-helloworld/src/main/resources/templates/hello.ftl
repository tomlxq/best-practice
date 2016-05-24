${message!}
<p><label>测试中文:</label>${message2}</p>
<p><label>测试传输中文到服务端:</label><input type="button" value="send by ajax"></p>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
    $("input[value='send by ajax']").click(function () {
        $.post("/message", {message: "你是那位"}, function (data) {
            console.debug(data);
        }, "json");
    });
</script>
