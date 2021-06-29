package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "GuestController" , tags = {"Guest Controller"})
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestController extends BaseRestController {

    private final GuestService guestService;

    @ApiOperation(value = "Find all guests")
    @GetMapping("/")
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @ApiOperation(value = "Find a guest by ID")
    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable long id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @ApiOperation(value = "Find a guest by name")
    @GetMapping("/name/{name}")
    public ResponseEntity<GuestDTO> getGuestByName(@PathVariable String name) {
        return ResponseEntity.ok(guestService.getGuestByName(name));
    }

    @ApiOperation(value = "Delete a guest")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Guest deleted successfully")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuestById(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Create a guest")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest created")})
    @PostMapping("/{name}")
    public ResponseEntity<GuestDTO> createGuest(@PathVariable String name) {
        return ResponseEntity.ok(guestService.createGuest(name));
    }

    @ApiOperation(value = "Update a guest")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest has been updated")})
    @PutMapping("/id/{id}/name/{name}")
    public ResponseEntity<GuestDTO> updateGuest(@PathVariable long id,
                                                @PathVariable String name) {
        return ResponseEntity.ok(guestService.updateGuest(id, name));
    }
}