<template>
	<view class="homeHeader">
		<image src="../../static/headerLogo.png" 
		class="headerImg"></image>
		<view class="queryInfo">
			<u-search bgColor="white" :inputStyle="{with:'20%',height:'30px'}"
			:actionStyle="{color:'#02ABE9',fontSize:'17px'}"></u-search>
		</view>
	</view>
</template>

<script>
</script>

<style lang="scss" scoped>
	@import url('@/components/homeHeader/homeHeader.css');
</style>