// pages/application/application.js
const API = require('../../utils/request.js')
const app = getApp()
Page({
  //form表单中的数据
  formSubmit:function(e){
    var that = this
    API.insertShare({
      userId: wx.getStorageSync('user').id,
      isOriginal: this.data.isOriginal,
      title: e.detail.value.title,
      author: e.detail.value.author,
      price: e.detail.value.price,
      summary: e.detail.value.summary,
      downloadUrl: e.detail.value.downloadUrl
    }).then(res=>{
      const req = JSON.parse(res)
      // console.log(req.succ)
      if(req.succ == true){
        wx.showToast({
          title: '成功',
          icon: 'success',
          duration: 2500
        })
      that.setData({
        isOriginal: '',
        title: '',
        author: '',
        price: '',
        summary: '',
        downloadUrl: ''
      })
      }
    })
  },
  radioChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value)
    this.data.isOriginal = e.detail.value
  },
  /**
   * 页面的初始数据
   */
  data: {
      isOriginal: null,
      title: null,
      author: null,
      price:null,
      summary: null,
      downloadUrl: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})