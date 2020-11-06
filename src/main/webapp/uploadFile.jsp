<%--
  Created by IntelliJ IDEA.
  User: lxh
  Date: 2020/11/3
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>文件上传</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>
<body>
<button type="button" class="layui-btn" id="upload1">
    <i class="layui-icon">&#xe67c;</i> <%--上传图片的标签--%>
</button>

<img src="" id="img1">
<script type="text/javascript">
    layui.use("upload", function () {
        var upload = layui.upload;

        //上传设置
        upload.render({
            elem:"#upload1",
            url:"uploadFileOne",
            done:function(resp){
                $("#img1").prop("src","upload/"+"\\"+resp.path);
            }
        })
    })
</script>
</body>
</html>
