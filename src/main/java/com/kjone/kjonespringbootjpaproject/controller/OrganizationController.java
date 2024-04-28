package com.kjone.kjonespringbootjpaproject.controller;


import com.kjone.kjonespringbootjpaproject.domain.role.Role;
import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.entity.UserEntity;
import com.kjone.kjonespringbootjpaproject.service.OrganizationService;
import com.kjone.kjonespringbootjpaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;
    private final UserService userService;

    // POST: Create a new organization and assign a user as OWNER
    @PostMapping("/create")
    public ResponseEntity<String> createOrganization(@RequestBody SignRequest request) {
        try {
            UserEntity user = userService.findByEmail(request.getEmail())
                    .orElseThrow(() -> new Exception("User not found"));
            organizationService.assignRoleAndManageOrganization(user, Role.OWNER);
            return ResponseEntity.ok("Organization created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create organization: " + e.getMessage());
        }
    }

    // GET: Get all employees in an organization
    @GetMapping("/{orgId}/employees")
    public ResponseEntity<?> getAllEmployees(@PathVariable Long orgId) {
        try {
            var employees = organizationService.findAllEmployeesInOrganization(orgId);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organization not found");
        }
    }
}
