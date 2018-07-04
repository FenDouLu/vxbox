<template>
    <div class="app-container">
        <scroller class="scroller" show-scrollbar="false">
            <refresh class="refresh" @refresh="onrefresh" @pullingdown="onpullingdown"
                     :display="refreshing ? 'show' : 'hide'">
                <text class="indicator-text">下拉刷新</text>
                <loading-indicator class="loading-indicator"></loading-indicator>
            </refresh>
            <banner :banners="banners"></banner>
            <store-list :stores="stores"></store-list>
        </scroller>
    </div>
</template>
<style scoped>
    .app-container {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        padding-bottom: 5px;
        background-color: #F0F0F0;
    }
    .scroller {
        flex: 1;
        width: 750px;
    }
    .refresh {
        width: 750px;
        display: -ms-flex;
        display: -webkit-flex;
        display: flex;
        -ms-flex-align: center;
        -webkit-align-items: center;
        -webkit-box-align: center;
        align-items: center;
    }
    .indicator-text {
        color: #888888;
        font-size: 42px;
        text-align: center;
    }
    .loading-indicator {
        margin-top: 16px;
        height: 40px;
        width: 40px;
        color: blue;
    }
</style>
<script>
    import Banner from "../parts/banner.vue"
    import StoreList from "../parts/storeList.vue"

    const modal = weex.requireModule('modal')
    export default {
        name: 'Commend',
        components: {
            StoreList,
            Banner
        },
        data() {
            return {
                refreshing: false,
                banners: [
                    {src:'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/huoguojie.jpg'},
                    {src: 'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/Invitation.jpg'},
                    {src: 'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/pangxie.jpg'}
                ],

                stores: [
                    {
                        id: 1,
                        title: '四川旅游',
                        storeImg: 'https://s1.ax1x.com/2018/06/27/PPycPU.jpg',
                        storeName: '卡片测试',
                        priceDesc: '月售58笔｜999+条评论',
                        storePrice: 6466,
                        desc: [{
                            type: 'text',
                            value: '特价机票|班期:清明 3/27-4/2等',
                            theme: 'gray'
                        }],
                        tags: [{
                            type: 'tag',
                            value: '满100减20',
                            theme: 'yellow'
                        }]
                    },
                    {
                        id: 2,
                        title: '四川旅游',
                        storeImg: 'https://s1.ax1x.com/2018/06/27/PPycPU.jpg',
                        storeName: '卡片测试1',
                        priceDesc: '月售58笔｜999+条评论',
                        storePrice: 6466,
                        desc: [{
                            type: 'text',
                            value: '特价机票|班期:清明 3/27-4/2等',
                            theme: 'gray'
                        }],
                        tags: [{
                            type: 'tag',
                            value: '满100减20',
                            theme: 'yellow'
                        }]
                    },
                    {
                        id: 3,
                        title: '四川旅游',
                        storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                        storeName: '卡片测试2',
                        priceDesc: '月售58笔｜999+条评论',
                        storePrice: 6466,
                        desc: [{
                            type: 'text',
                            value: '特价机票|班期:清明 3/27-4/2等',
                            theme: 'gray'
                        }],
                        tags: [{
                            type: 'tag',
                            value: '满100减20',
                            theme: 'yellow'
                        }]
                    },
                    {
                        id: 4,
                        title: '四川旅游',
                        storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                        storeName: '卡片测试3',
                        priceDesc: '月售58笔｜999+条评论',
                        storePrice: 6466,
                        desc: [{
                            type: 'text',
                            value: '特价机票|班期:清明 3/27-4/2等',
                            theme: 'gray'
                        }],
                        tags: [{
                            type: 'tag',
                            value: '满100减20',
                            theme: 'yellow'
                        }]
                    },
                    {
                        id: 5,
                        title: '四川旅游',
                        storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                        storeName: '卡片测试3',
                        priceDesc: '月售58笔｜999+条评论',
                        storePrice: 6466,
                        desc: [{
                            type: 'text',
                            value: '特价机票|班期:清明 3/27-4/2等',
                            theme: 'gray'
                        }],
                        tags: [{
                            type: 'tag',
                            value: '满100减20',
                            theme: 'yellow'
                        }]
                    }
                ]

            }
        },
        methods: {
            onrefresh(event) {
                modal.toast({message: '刷新成功', duration: 1});
                this.refreshing = true;
                setTimeout(() => {
                    this.refreshing = false
                }, 2000);
                console.log('onrefresh + ' + event)
            },
            onpullingdown(event) {
                console.log('onpullingdown + ' + event)
            }
        }
    }
</script>
