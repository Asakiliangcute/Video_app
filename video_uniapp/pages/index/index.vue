<template>
	<view class="content">
		<home-header></home-header>
		<view class="swiper">
			<!-- list轮播图数组
				keyname 设置图片属性名
				indicatorstyle 指示器方向-->
			 <u-swiper
			                :list="swiperList"
							keyName="videoCover"
							indicatorStyle="right: 20px"
			                @change="e => current = e.current"
			                :autoplay="false"
			        >
			            <view
			                    slot="indicator"
			                    class="indicator"
			            >
			                <view
			                        class="indicator__dot"
			                        v-for="(item, index) in swiperList"
			                        :key="index"
			                        :class="[index === current && 'indicator__dot--active']"
			                >
			                </view>
			            </view>
			        </u-swiper>
					
		</view>
		<view class="videoType">
			<view :span="3" v-for="(item,index) in videoTypes">
				<view class="videoTypeBg">
					<view>
						<view :class="'videoTypeIcon '+item.icon" 
						:style="item.style"></view>
					</view>
					<view class="videoTypeTitle">{{item.title}}</view>
				</view>
			</view>
		</view>
		
		<video-list :type="item.type" v-for="item in videoKinds" :title="item.title"></video-list>
		
	</view>
</template>

<script>
	import homeHeader from '@/components/homeHeader/homeHeader.vue'
	import videoList from '@/components/videoList/videoList.vue'
	export default {			
		components:{
			homeHeader,
			videoList
		},
		data() {
			return {
				videoKinds:[
					{type:1,total:'最新电影'},
					{type:2,total:'最新电视剧'},
					{type:3,total:'最新综艺'},
					{type:4,total:'最新动漫'}
				],
				swiperList:[],
				current:0,
				videoTypes:[
					{
						"videoType":1,
						"icon":'iconfont icon-dianying',
						"title":'电影',
						"style":'background-color:rgb(2,171,233)'
					},
					{
						"videoType":2,
						"icon":'iconfont icon-dianshiju',
						"title":'电视剧',
						"style":'background-color:rgb(2,171,233)'
					},
					{
						"videoType":3,
						"icon":'iconfont icon-xinghongbangicon-',
						"title":'综艺',
						"style":'background-color:rgb(2,171,233)'
					},{
						"videoType":4,
						"icon":'iconfont icon-erciyuan',
						"title":'动漫',
						"style":'background-color:rgb(2,171,233)'
					}
				]
			}
		},
		onLoad() {
			this.querySwiper()
		},
		methods: {
			querySwiper(){
				uni.request({
					url:this.path+'/video/getVideos',
					method:'GET',
					data:{
						pageNum:1,
						pageSize:20
					},
					success: (res) => {
						let index=[]
						let count=0
						while(count<=4){
							let i=parseInt(Math.random()*20)
							if(index.indexOf(i)==-1){
								this.swiperList.push(res.data.data.rows[i])
								count++
								index.push(i)
							}
							
						}
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	 .indicator {
	        @include flex(row);
	        justify-content: center;
	
	        &__dot {
	             height: 6px;
	             width: 6px;
	             border-radius: 100px;
	             background-color: rgba(255, 255, 255, 0.35);
	             margin: 0 5px;
	             transition: background-color 0.3s;
	    
	            &--active {
	                 background-color: #ffffff;
	             }
	        }
	    }
		
		.swiper{
			padding: 55px 10px 0;
		}
		.videoType{
			margin-top: 10px;
			height: 150rpx;
			background-color: #f2f2f2;
			display: flex;
			width: 94%;
			margin-left: 3%;
			border-radius: 10px;
			justify-content: space-around;
			align-items: center;
		}
		.videoTypeTitle{
			font-size: 12px;
			text-align: center;
		}
		.videoTypeIcon{
			color: white;
			font-size: 25px;
			height: 32px;
			width: 38px;
			border-radius: 10px;
			text-align: center;
			padding-top: 7px;
		}
</style>
