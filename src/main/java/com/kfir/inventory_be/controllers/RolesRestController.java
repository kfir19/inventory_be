package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.RoleDTO;
import com.kfir.inventory_be.models.Role;
import com.kfir.inventory_be.services.RolesService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesRestController {

    @Autowired
    private RolesService rolesService;


    @GetMapping(value = "/")
    public List<RoleDTO> getAllRoles() {
        return ObjectMapperUtils.mapAll(rolesService.findAll(), RoleDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public RoleDTO getRoleById(@PathVariable("id") ObjectId roleId) {
        return ObjectMapperUtils.map(rolesService.findRoleById(roleId), RoleDTO.class);
    }

    @GetMapping(value = "/byKind/{kind}")
    public List<RoleDTO> getRolesByKind(@PathVariable("kind") String kind) {
        return ObjectMapperUtils.mapAll(rolesService.findRolesByKind(kind), RoleDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<RoleDTO> saveOrUpdateRole(@RequestBody RoleDTO roleDTO) {
        rolesService.saveOrUpdateRole(ObjectMapperUtils.map(roleDTO, Role.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{roleId}")
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("roleId") ObjectId roleId) {
        rolesService.deleteRoleById(rolesService.findRoleById(roleId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
