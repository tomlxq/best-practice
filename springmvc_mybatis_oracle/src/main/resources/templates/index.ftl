hello
<#list users as user>
   <p>${user.id!} ${user.name!}  ${user.email!} ${user.age!} ${user.birthday!?date}</p>
</#list>
<p><a href="/insertUsersBatch">insertUsersBatch</a></p>
<p><a href="/updateUsersBatch">updateUsersBatch</a></p>
<p><a href="/deleteUsersBatch">deleteUsersBatch</a></p>
