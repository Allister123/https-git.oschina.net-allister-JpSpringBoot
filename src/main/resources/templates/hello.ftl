<html> 
<body> 
    <ul>
    	<#list users as item>
    		<li><font style="color:red;">${item_index+1}</font> : ${item.username} ====== ${item.email} ==== ${item.createTime?string('yyyy-MM-dd HH:mm:ss')} </li>
    	</#list>
    </ul>
</body> 
</html>