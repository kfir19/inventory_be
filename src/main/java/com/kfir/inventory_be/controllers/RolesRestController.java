package com.kfir.inventory_be.controllers;

import com.kfir.inventory_be.dto.RoleDTO;
import com.kfir.inventory_be.models.Role;
import com.kfir.inventory_be.services.RolesService;
import com.kfir.inventory_be.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class RolesRestController {

    @Autowired
    private RolesService rolesService;


    @GetMapping(value = "/")
    public List<RoleDTO> getAllRoles() {
        return ObjectMapperUtils.mapAll(rolesService.findAll(), RoleDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public RoleDTO getRoleById(@PathVariable("id") UUID roleId) {
        return ObjectMapperUtils.map(rolesService.findRoleById(roleId), RoleDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<RoleDTO> saveOrUpdateRole(@RequestBody RoleDTO roleDTO) {
        rolesService.saveOrUpdateRole(ObjectMapperUtils.map(roleDTO, Role.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{roleId}")
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("roleId") UUID roleId) {
        rolesService.deleteRoleById(rolesService.findRoleById(roleId).getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
