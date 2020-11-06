<%--
  Created by IntelliJ IDEA.
  User: lxh
  Date: 2020/11/3
  Time: 22:32
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
        //1.显示树节点,没有数据源
        var tree = layui.tree;
        var treeInst = tree.render({
            elem: '#tree1',
            data: []
        });
        //2.向服务器发请求取原始数据{id,title,pid}
        $.ajax({
            url:'emp/depts',
            type:'post',
            dataType:'json',
            success:function(resp){
                fn(resp);
                treeInst.reload({
                    data:resultObj
                })
            }
        })




        var resultObj=[];
        function fn(jsonData) {
            //取得顶级的数据
            for(var i=0;i<jsonData.length;i++){
                if(jsonData[i].pid==0){
                    resultObj.push(jsonData[i]);
                }
            }
            getChildren(resultObj, jsonData)
        }

        function getChildren(nodeList, jsonData) {
            nodeList.forEach(function(elemet, index) {
                elemet.children = jsonData.filter(function(item, indexI) {
                    return item.pid === elemet.id
                })
                if(elemet.children.length > 0) {
                    getChildren(elemet.children, jsonData)
                }
            })
        }
    })

</script>
</body>
</html>
