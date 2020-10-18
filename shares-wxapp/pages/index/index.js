// pages/index/index.js
const API = require('../../utils/request.js')
const app = getApp()
Page({
inputTyping:function(e){
  var that = this
  that.setData({
    content: e.detail.value
  })
  //随时查看search输入中的数据
  // console.log(e.detail.value)
  API.getShare1({
    title: that.data.content
  }).then(res=>{
      that.setData({
      shareList: res.data
     })
    //  console.log(res.data)
  })
},
  /**
   * 切换tab
   */
  changeTab(e){
    this.setData({
      tab:e.currentTarget.dataset.tab
    })
    // console.log(e);
  },
  /**
   * 页面的初始数据
   */
  data: {
    pageNo:1,
    pageSize:4,
    content: null,
    tab: 0,
    shareList: null,
    notice:null,
    token: wx.getStorageSync('token')
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    API.getNotic().then(res =>{
      that.setData({
        notice: res.data
      })
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
    API.getShare1({
      pageNo: that.data.pageNo,
      pageSize:that.data.pageSize,
    }).then(res => {
      that.setData({
        shareList: res.data
      })
      // console.log(res.data)
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },
downReflesh:function(){
  var that = this
  that.setData({
    pageNo: that.data.pageNo + 1
  })
  API.getShare1({
    pageNo: that.data.pageNo,
    pageSize: that.data.pageSize ,
  }).then(res=>{
    if(res.data.length == 0){
        that.setData({
         pageNo: 1,
         pageSize: 4
        })
    }
    console.log(res)
    const share = res.data
      that.setData({
        shareList: that.data.shareList.concat(share)
       })
  })
},
  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    this.downReflesh()
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  },
    /**
   * 兑换
   */
  handlezy(e){
    //取出绑定对象
    console.log(e)
    var tiaozhuang = e.currentTarget.dataset.item.downloadUrl
    var share = e.currentTarget.dataset.item
    if(tiaozhuang != null){
    wx.navigateTo({
      url: '../duihuanSuccess/duihuanSuccess?share='+JSON.stringify(share),
    })
  }else{
      wx.navigateTo({
      url: '../shareDetail/shareDetail?share='+JSON.stringify(share),
    })
  }
  },
})