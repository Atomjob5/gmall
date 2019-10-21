package com.atom.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atom.gmall.bean.UmsMember;
import com.atom.gmall.bean.UmsMemberReceiveAddress;
import com.atom.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Atom
 * @date 2019/10/21
 * @time 12:57
 */
@Controller
public class UserController {
    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @ResponseBody
    @RequestMapping("getReceiveAddressByMemberId")
    public List<UmsMemberReceiveAddress>  getReceiveAddressByMemberId(String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }


    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
