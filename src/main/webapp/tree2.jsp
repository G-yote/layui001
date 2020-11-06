<%--
  Created by IntelliJ IDEA.
  User: lxh
  Date: 2020/11/3
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>
<body>

<div id="tree1"></div>
<script type="text/javascript">
    layui.use('tree', function () {
        var tree = layui.tree;
        //1.显示树节点，没有数据源
        var treeInst = tree.render({
            elem: '#tree1',
            data: []
        });
        $.ajax({
            url: 'emp/depts1',
            type: 'post',
            dataType: 'json',
            success: function (resp) {
                treeInst.reload({
                    data: resp
                })
            }
        })
    })
</script>
</body>
</html>
