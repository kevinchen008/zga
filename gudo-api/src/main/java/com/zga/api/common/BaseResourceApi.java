package com.zga.api.common;

import com.zga.common.bean.UserEntity;
import com.zga.common.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-29 17:53
 */

@Component
@Path("/base")
@Api("基础接口")
public class BaseResourceApi {

    @Autowired
    UserService userService;

    @Path(value = "/getUser")
    @GET
    //@RolesAllowed("ADMIN")
    @PermitAll
    @Produces(MediaType.APPLICATION_ATOM_XML)
    @ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response=UserEntity.class)
    public List<UserEntity> getUser(@Context SecurityContext sc) {
        return userService.getAllUsers();
    }

    @Path("/version")
    @GET
    @ApiOperation(value="获取版本号",httpMethod = "get",notes = "get versionNo")
    public String getResource(String resourceName) {
        return "1234";
    }


  /*  @Path("/addUser")
    @GET
    @ApiOperation(value="添加员工",httpMethod = "post",notes = "add User")
    public Response AddUser(@BeanParam UserEntity userEntity) {
        GenericResponse response = new GenericResponse();
       userService.addUser(userEntity);
       return Response.status(200).entity(response).build();
    }*/
}
