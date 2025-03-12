package com.hms.hms.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BookingSlotTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bookMeetingRoom_whenExactSlotAvailable_returnsSlotIndex() {
        int[][] timeSlots = {
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        };
        int[] request = {10, 11};
        int result = BookingSlot.bookMeetingRoom(timeSlots, request);
        assertEquals(1, result);
    }

    @Test
    void bookMeetingRoom_whenExactSlotNotAvailable_returnsNextAvailableSlotIndex() {
        int[][] timeSlots = {
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        };
        int[] request = {8, 9};
        int result = BookingSlot.bookMeetingRoom(timeSlots, request);
        assertEquals(0, result);
    }

    @Test
    void bookMeetingRoom_whenNoSlotAvailable_returnsMinusOne() {
        int[][] timeSlots = {
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        };
        int[] request = {15, 16};
        int result = BookingSlot.bookMeetingRoom(timeSlots, request);
        assertEquals(-1, result);
    }

    @Test
    void bookMeetingRoom_whenRequestOverlapsNoSlot_returnsMinusOne() {
        int[][] timeSlots = {
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        };
        int[] request = {10, 12};
        int result = BookingSlot.bookMeetingRoom(timeSlots, request);
        assertEquals(3, result);
    }

    @Test
    void bookMeetingRoom_whenRequestIsEmpty_returnsMinusOne() {
        int[][] timeSlots = {
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15}
        };
        int[] request = {};
        assertThrows(IllegalArgumentException.class, () -> BookingSlot.bookMeetingRoom(timeSlots, request));
    }
}