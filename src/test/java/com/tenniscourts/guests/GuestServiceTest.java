package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = GuestService.class)
public class GuestServiceTest {

    @InjectMocks
    GuestService guestService;

    @Mock
    GuestRepository guestRepository;

    @Mock
    GuestMapper guestMapper;


    @Test
    public void getAllGuestsTest() {
        when(guestRepository.findById(1L)).thenReturn(Optional.empty());
        guestRepository.findAll();
    }


    @Test(expected = EntityNotFoundException.class)
    public void deleteGuestTest() {
        when(guestRepository.findById(1L)).thenReturn(Optional.empty());
        guestService.deleteGuestById(1L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void findGuestByIdTest() {
        when(guestRepository.findById(1L)).thenReturn(Optional.empty());

        guestService.getGuestById(1L);
    }
}