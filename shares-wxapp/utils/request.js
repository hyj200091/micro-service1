//统一接口封装
const API_BASE_URL = 'http://localhost:8040';
const app = getApp()

const get = (url, data) => { 
  let _url = API_BASE_URL  + url;
  let token = ''
  //如果本地存储没有token对象，那么取出token的属性值的类型为undefined 可以看一下控制台
  console.log("是你吗？"+typeof(wx.getStorageSync('token').token))
  //一下分为本地有没有token，给后端传header，为了简便起见，没有token就用了个常量代替先
  if(typeof(wx.getStorageSync('token').token) == 'undefined'){
    token = 'no-token'
  }else{
    token = wx.getStorageSync('token').token
  }
  console.log(token+"是我吗？")
  return new Promise((resolve, reject) => {
    wx.showLoading({
      title: "正在加载中...",
    })
    wx.request({
      url: _url,
      method: "get",
      data: data,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'X-Token': token
      },
      success(request) {
        wx.hideLoading();
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
 const post = (url, data,contentType) => {
  let token = wx.getStorageSync('token')
  let _url = API_BASE_URL  + url;
  switch(contentType){
    case "form" :
      var headerObj = {'content-type' : 'application/x-www-form-urlencoded', 'X-Token': token != null? token.token : null};
    break;
    case "json" : 
      var headerObj = {'content-type' : 'application/json', 'X-Token': token != null? token.token : null};
    break;
    default :
      var headerObj = {'content-type' : 'application/json', 'X-Token': token != null? token.token : null};
  }
  return new Promise((resolve, reject) => {
    wx.request({
      url      : _url,
      data     : data,
      method   : "POST",
      dataType : JSON,
      header: headerObj,
      success(request) {
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
const put = (url, data,contentType) => {
  let token = wx.getStorageSync('token')
  let _url = API_BASE_URL  + url;
  switch(contentType){
    case "form" :
      var headerObj = {'content-type' : 'application/x-www-form-urlencoded', 'X-Token': token != null? token.token : null};
    break;
    case "json" : 
      var headerObj = {'content-type' : 'application/json', 'X-Token': token != null? token.token : null};
    break;
    default :
      var headerObj = {'content-type' : 'application/json', 'X-Token': token != null? token.token : null};
  }
  return new Promise((resolve, reject) => {
    wx.request({
      url      : _url,
      data     : data,
      method   : "PUT",
      dataType : JSON,
      header: headerObj,
      success(request) {
        resolve(request.data)
      },
      fail(error) {
        reject(error)
      }
    })
  });
}
module.exports ={
  login:(data) =>{
    // console.log("登录")
    return post('/user/login',data,'json') //微信登录
  },
  getShare:() =>{
    console.log('获取分享列表')
    return get('/shares/query') //获取分享列表
  },
  getShare1:(data) =>{
    console.log('获取搜索分享列表')
    return get('/shares/query',data) //获取搜索分享列表
  },
  getNotic:() =>{
    console.log('获取最新公告')
    return get('/notice/one') //获取最新公告
  },
  exchange:(data) =>{
    console.log('兑换积分操作')
    return post('/shares/exchange',data,'json') //兑换积分操作
  },
  insertShare:(data) =>{
    console.log('进行投稿的操作')
    return post('/shares/contribute',data,'json') //进行投稿的操作
  },
  getUser:() =>{
    console.log('获取最新的user')
    return get('/user/{id}') //获取最新的user
  },
  getBonusList:(data) =>{
    console.log('获取该用户积分明细')
    return get('/user/bonusmx',data) //获取该用户积分明细
  },
  getmyshares:(data) =>{
    console.log('获取该用户的投稿')
    return get('/shares/myapply/{id}',data) //获取该用户的投稿
  },
  signIn: (data) => {
     return post('/user/signin',data,'json') // 签到
  },
  audit: (data) => {
     return put(url,data,'json') //审核接口
  }
}