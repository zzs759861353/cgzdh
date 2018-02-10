<template>
  <div class="head_info" ng-init="initdata();">
	<div>
		<div align="left" class="head_info_left menuBg">
			<img src="
			./images/header/Navigation.png" title="菜单"
				ng-click="doMenu($event)">
		</div>
		<div class="head_info_left">
			<img src="
	        ./images/header/logo.png" title="logo_回首页"
				ng-click="doHome($event)">
		</div>

		<div align="right" class="head_info_right">
			<img src="./images/header/quit.png" title="注销" ng-click="sessionquit()">
		</div>

		<div class="head_info_right">
		  <a href="tencent://message/?uin=000000">
			<img src="./images/header/OnlineService.png" title="在线服务"
				>
				</a>
		</div>
		<div class="head_info_right">
			<img src="./images/header/Message.png" title="单位留言"
				ng-click="unitMessage()">
		</div>
		<div class="head_info_right">
			<img src="./images/header/tel.png" title="联系电话" id="header_tel">
		</div>
		  <div class="head_info_right">
	        <img src="./images/header/home.png" title="首页" ng-click="doHome($event)">
	    </div>
	</div>


</div>

</template>
<script>
</script>
<style>
</style>
