// pages/personal/personal.js
const app = getApp();
const API = require('../../utils/request.js')
Page({
  /**
   * 页面的初始数据
   */
  data: {
   code:'',
   userInfo: null,
   isShow: 0,
   roles:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (wx.getStorageSync('user')) {
      this.setData({
        userInfo: wx.getStorageSync('user')
      })
		}
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
    // console.log(this.data.isShow)
    var that = this
    if (wx.getStorageSync('user')) {
      that.setData({
        userInfo: wx.getStorageSync('user')
      })
    }
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
  },
  wodetougao(){
    wx.navigateTo({
      url: '../wodetougao/wodetougao'
    })
  },
  jifenmingxi(){
    wx.navigateTo({
      url: '../jifenmingxi/jifenmingxi'
    })
  },
  shenghetougao(){
    wx.navigateTo({
      url: '../shenghetougao/shenghetougao'
    })
  },
logout() {
    var that = this
    console.log(that.data.userInfo);
    that.setData({
      userInfo: null
    })
    wx.clearStorageSync()
  },  
// 点击授权成功之后的方法
bindGetUserInfo() {
  var app = getApp()
  var that = this;
      wx.login({
        success (res) {
      wx.request({
        url: 'https://api.weixin.qq.com/sns/jscode2session',
        data:{
          appid: 'wxd3bc4833944996f0',
          secret: '25883cedb600e38ae7d36635851ba460',
          js_code: res.code,
          grant_type: 'authorization_code'
        },
        success: res =>{
          console.log(res)
            app.globalData.wxId = res.data.openid              
        wx.getUserInfo({
        success: function(res) {
          // console.log("昵称是:" + res.userInfo.nickName)
          app.globalData.userInfo = res.userInfo
          API.login({
            openId: app.globalData.wxId,
            wxNickname: app.globalData.userInfo.nickName,
            avatarUrl: app.globalData.userInfo.avatarUrl
          }).then( res =>{
            const request = JSON.parse(res)
            console.log(request)
            app.globalData.user = request.user
            app.globalData.token = request.token.token 
            wx.setStorageSync('user', request.user)
            wx.setStorageSync('token', request.token)
            that.setData({
              userInfo: wx.getStorageSync('user'),
            })
          })
        }
      })
        }
      })
     }
  }) 
},
signIn(){
      API.signIn({
        userId: wx.getStorageSync('user').id
      }).then(res => {
    console.log(res);
    
        const req = JSON.parse(res)
        const result = JSON.stringify(req.data)
        console.log(result)
  
        // console.log("直接输出的"+req.data)
        if(req.code == 200){
          wx.showToast({
            title: '签到成功',
            icon: "success",
            tx: '签到成功，记得每天都要来哦'
          })
          this.setData({
             isShow: 1,
             userInfo: res.data
          })
        }else {
          wx.showModal({
            cancelColor: 'cancelColor',
            title: '签到失败',
            content: '今天已经签到过了哦'
          })
        }
      })
    }
})