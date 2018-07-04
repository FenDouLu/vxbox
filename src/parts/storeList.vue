<template>
    <div class="nearby-store">
        <div class="nearby-store-title">
            <!--<text style="font-size: 36px"></text>-->
        </div>
        <div class="item-container"
             :style="{ height: (tabPageHeight - 120) + 'px' }">
            <div class="border-cell"></div>
            <div v-for="(store,index) in stores"
                 class="cell"
                 :key="index"
                 @click="storeDetail">
                <store-item :image="store.storeImg"
                            :title="store.storeName"
                            :desc="store.desc"
                            :tags="store.tags"
                            :price="store.storePrice"
                            :price-desc="store.priceDesc"></store-item>
            </div>
        </div>
    </div>
</template>

<script>
import {WxcTabPage, WxcPanItem, Utils} from 'weex-ui';
import StoreItem from './storeItem.vue';
export default {
    name: 'store-list',
    props: ['stores'],
    components: {WxcTabPage, WxcPanItem, StoreItem},
    data: () => ({
        needSlider: true,
        supportSlide: true,
        isTabView: true,
        tabPageHeight: 0

    }),
    created() {
        this.tabPageHeight = Utils.env.getPageHeight();
    },
    methods: {
        wxcPanItemPan (e) {
            console.log(e)
        },
        storeDetail (e) {
            console.log(e)
            const url = 'https://h5.m.taobao.com/trip/ticket/detail/index.html?scenicId=2675';
        }
    }
}
</script>

<style scoped>
    .nearby-store {
        background-color: #FFF;
    }
    .nearby-store-title {
        align-items: center;
    }
    .item-container {
        width: 750px;
        background-color: #FFF;
    }
    .cell {
        background-color: #FFF;
    }
</style>
