<template>
	<view class="content">
		<view class="top">
			<view class="top-left">{{ title }}</view>
			<view class="top-right">更多</view>
		</view>
		<view class="main">
			<view v-for="v in videoList" class="main-bg">
				<view class="main-top">
					<image :src="v.videoCover" class="main-img"></image>
					<view class="score-bg">
						<view class="score">{{ v.doubanScore }}</view>
					</view>
				</view>
				<view>
					<view class="video-name">{{ v.videoTitle.length>5?v.videoTitle.substring(0,5) +'...':v.videoTitle}}</view>
				</view>
				<view class="main-bottom">
					<view class="video-type">{{ v.videoTypes.split(',').slice(0,2).join(',') }}</view>
					<view class="iconfont "></view>
				</view>
			</view>
		</view>
		<view class="bottom iconfont icon-huanyihuan" @click="query">
			<text class="bottom-text">换一换</text>
		</view>
	</view>
</template>

<script>
	export default{
		// 接受父组件传的值
		props:{
			type:0,
			title:''
		},
		data(){
			return{
				videoList:[],
				pageNum: 1
			}
		},
		methods:{
			query(){
				this.pageNum++
				this.queryVideoList()
			},
			queryVideoList(){
				uni.request({
					url: this.path + '/video/getVideos',
					method: 'GET',
					data:{
						pageNum: this.pageNum,
						pageSize: 6,
						videoKind: this.type
					},
					success: (res) => {
						let total = res.data.data.total
						//计算总页数
						let pages = (total+5)/6
						//判断是否是最后一页
						if(this.pageNum===pages) this.pageNum = 0
						this.videoList = res.data.data.rows
					}
				})
			}
		},
		mounted(){
			this.queryVideoList()
		}
	}
</script>

<style lang="scss" scoped>
	@import url('@/components/videoList/videoList.css');
</style>