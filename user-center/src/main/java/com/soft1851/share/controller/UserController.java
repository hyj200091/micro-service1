package com.soft1851.share.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.soft1851.share.domain.dto.*;
import com.soft1851.share.domain.entity.BonusEventLog;
import com.soft1851.share.domain.entity.User;
import com.soft1851.share.service.BonusEventLogService;
import com.soft1851.share.service.UserService;
import com.soft1851.share.util.JwtOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/23
 **/
@RequestMapping("/user")
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final JwtOperator jwtOperator;
    private final UserService userService;
    private final WxMaService wxMaService;
    private final BonusEventLogService bonusEventLogService;
    @GetMapping("/hello")
    public String getHello() {
        log.info("我被cpdd了。。");
        return "hello! this message is from user-center ";
    }

    @GetMapping(value = "/{id}")
    public ResponseDTO findUserById(@PathVariable Integer id) throws WxErrorException{
        log.info("我被请求了...");
        return this.userService.findById(id);
    }
    /**
     * 模拟生成token(假的登录)
     */
    @GetMapping("/gen-token")
    public String genToken() {
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id", 1);
        userInfo.put("wxNickname", "侯粤嘉");
        userInfo.put("role", "admin");
        return this.jwtOperator.generateToken(userInfo);
    }

    @PostMapping(value = "/login")
    public LoginResDto getToken(@RequestBody LoginDto loginDto) throws WxErrorException {
        System.out.println(loginDto + ">>>>>>>>>>>>>>>>>>>");
        String openId;
        // 微信小程序登录 需要根据code请求openId
        if (loginDto.getLoginCode() !=null ){
            // 微信服务端校验是否已经登录的结果
            WxMaJscode2SessionResult result = this.wxMaService.getUserService()
                    .getSessionInfo(loginDto.getLoginCode());
            log.info(result.toString());
            //微信的openId 用户在微信这边的唯一标识
            openId = result.getOpenid();
        }else {
            openId = loginDto.getOpenId();
        }
        //看用户是否注册，如果没有注册就(插入) 如果已经注册就返回其信息
        User user = userService.login(loginDto,openId);
        // 颁发token
        Map<String,Object> userInfo = new HashMap<>(3);
        userInfo.put("id",user.getId());
        userInfo.put("wxNickname",user.getWxNickname());
        userInfo.put("role",user.getRoles());
        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "{}登录成功，生成的token = {}，有效期到：{} ",
                user.getWxNickname(),
                token,
                jwtOperator.getExpirationTime()
        );
        ResponseDTO responseDTO = this.userService.checkIsSign(UserSignInDTO.builder().userId(user.getId()).build());
        int isUserSignin = 0;
        if (responseDTO.getCode() == "200"){
            isUserSignin = 1;
        }else {
            isUserSignin = 0;
        }
        return LoginResDto.builder()
                .user(UserRespDto.builder()
                .id(user.getId())
                .wxNickname(user.getWxNickname())
                .avatarUrl(user.getAvatarUrl())
                .bonus(user.getBonus())
                .roles(user.getRoles())
                .build())
        .token(JwtTokenRespDto
          .builder()
          .token(token)
          .expirationTime(jwtOperator.getExpirationTime().getTime())
          .build())
          .isUserSignin(isUserSignin)
        .build();
    }

    @PutMapping(value = "/add-bonus")
    public void addBonus(@RequestBody UserAddBonusDTO userAddBonusDTO){
        log.info("增减积分接口被请求了....");
        Integer userId = userAddBonusDTO.getUserId();
        userService.addBonus(
                UserAddBonusMsgDto.builder()
                .userId(userId)
                .bonus(userAddBonusDTO.getBonus())
                .description("兑换分享")
                .event("BY")
                .build()
        );
          log.info("积分添加完毕...");
    }

    @GetMapping(value = "/bonusmx")
    public List<BonusEventLog> getBonusList(@RequestParam Integer id){
        return this.bonusEventLogService.getBonusList(id);
    }

    @PostMapping(value = "/signin")
    public ResponseDTO signIn(@RequestBody UserSignInDTO userSignInDTO){
        return userService.signIn(userSignInDTO);
    }
    @GetMapping(value = "/bonus/{id}")
    public User insertBlog(@PathVariable Integer id) {
        return this.userService.insertById(id);
    }

    @GetMapping("/q")
    public User query(User user) {
        return user;
    }

    /**
     * 测试异步操作
     */
    @RequestMapping("/demo")
    public String demo() {
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date() + "--->>>30秒。。。。";
    }
}