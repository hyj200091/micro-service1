//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    // var logs = wx.getStorageSync('logs') || []
    // logs.unshift(Date.now())
    // wx.setStorageSync('logs', logs)

    // // 登录
    // wx.login({
    //   success: res => {
    //     console.log(res)
    //     this.globalData.code = res.code
    //     wx.request({
    //       url: 'https://api.weixin.qq.com/sns/jscode2session',
    //       data:{
    //         appid: 'wxd3bc4833944996f0',
    //         secret: '25883cedb600e38ae7d36635851ba460',
    //         js_code: res.code,
    //         grant_type: 'authorization_code'
    //       },
    //       success: res =>{
    //         console.log(res)
    //         this.globalData.wxId = res.data.openid
    //       }
    //     })
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //   }
    // })
    // // 获取用户信息
    // wx.getSetting({
    //   success: res => {
    //     if (res.authSetting['scope.userInfo']) {
    //       // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
    //       wx.getUserInfo({
    //         success: res => {
    //           // 可以将 res 发送给后台解码出 unionId
    //           this.globalData.userInfo = res.userInfo
              
    //           // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //           // 所以此处加入 callback 以防止这种情况
    //           if (this.userInfoReadyCallback) {
    //             this.userInfoReadyCallback(res)
    //           }
    //         }
    //       })
    //     }
    //   }
    // })
  },
  globalData: {
    user: null,
    userInfo: null,
    wxId: null,
    token:null
  }
})