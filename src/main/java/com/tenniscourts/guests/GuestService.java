package com.tenniscourts.guests;


import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {

    private GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public List<Guest> getAllGuests() { return guestRepository.findAll(); }

    public GuestDTO getGuestById(long id) {
        return guestRepository.findById(id)
                .map(guestMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Guest not found."));
    }

    public GuestDTO getGuestByName(String name) {
        return guestRepository.findByNameContains(name)
                .map(guestMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Guest not found."));
    }

    public void deleteGuestById(long id) {
        guestRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Guest not found.");
        });
        guestRepository.deleteById(id);
    }

    public GuestDTO createGuest(String name) {
        Guest guest = new Guest(name);
        return guestMapper.map(guestRepository.save(guest));
    }

    public GuestDTO updateGuest(long id, String name) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Guest not found."));
        guest.setName(name);
        return guestMapper.map(guestRepository.save(guest));
    }
}