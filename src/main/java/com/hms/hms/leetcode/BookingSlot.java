package com.hms.hms.leetcode;

public class BookingSlot {

    // booking a meeting room for a given time slot
    // 1. check if the meeting room is available for the given time slot
    // 2. if available, book the meeting room
    // 3. if not available, return the next available time slot
    // 4. if the meeting room is not available for the entire day, return -1

    // there are two ways to solve this problem
    // 1. using a list of time slots
    // 2. using a map of time slots

    // there are 10 rooms available for booking
    // each room has a list of time slots
    // each time slot has a start time and an end time

    // the time slots are as follows:
    // room 1: 9:00 - 10:00
    // room 2: 10:00 - 11:00
    // room 3: 11:00 - 12:00
    // room 4: 12:00 - 13:00
    // room 5: 13:00 - 14:00
    // room 6: 14:00 - 15:00

    // {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} on a given day
    // user request for a particular time slot {3, 4}

    public static void main(String[] args) {
        int[][] timeSlots = {
            {9, 10},
            {10, 11},
            {11, 12},
            {12, 13},
            {13, 14},
            {14, 15}
        };
        int[] request = {13, 14};
        validateRequest(request);
        int result = bookMeetingRoom(timeSlots, request);
        System.out.println(result);
    }

    private static void validateRequest(int[] request) {
        if (request.length != 2) {
            throw new IllegalArgumentException("Invalid request");
        }

        if (request[0] < 0 || request[0] > 23) {
            throw new IllegalArgumentException("Invalid start time");
        }

        if (request[1] < 9 || request[1] > 17) {
            throw new IllegalArgumentException("No Booking available Invalid end time");
        }
    }

    public synchronized static int bookMeetingRoom(int[][] timeSlots, int[] request) {
        validateRequest(request);
        for (int i = 0; i < timeSlots.length; i++) {
            if (timeSlots[i][0] == request[0] && timeSlots[i][1] == request[1]) {
                return i;
            }
        }
        // if the meeting room is not available for the given time slot, return the next available time slot
        for (int i = 0; i < timeSlots.length; i++) {
            if (timeSlots[i][0] > request[0] && timeSlots[i][1] > request[1]) {
                return i;
            }
        }
        // if the meeting room is not available for the entire day, return -1
        return -1;
    }

}
