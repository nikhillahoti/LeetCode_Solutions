
def merge_ranges(meetings):

    if len(meetings) <= 1:
        return meetings

    lst1 = [meetings[0][0]]
    lst2 = [meetings[0][1]]

    # Merge meeting ranges
    for i in range(1,len(meetings)):
        flag = True
        for index in range(0, len(lst1)):

            if (lst1[index] <= meetings[i][0] and lst2[index] >= meetings[i][1]):
                flag = False
                continue

            if (meetings[i][0] >= lst1[index] and meetings[i][0] <= lst2[index] and meetings[i][1] > lst2[index]):
                flag = False
                lst2[index] = meetings[i][1]

            if (meetings[i][0] <= lst1[index] and meetings[i][0] >= lst2[index]):
                flag = False
                lst1[index] = meetings[i][0]

        if(flag):
            lst1.append(meetings[i][0])
            lst2.append(meetings[i][1])

    print(lst1)
    print(lst2)
    return zip(lst1,lst2)

def merged_mEEETings(meetings):
    sorted_meetings = sorted(meetings)

    # Initialize merged_meetings with the earliest meeting
    merged_meetings = [sorted_meetings[0]]

    for current_meeting_start, current_meeting_end in sorted_meetings[1:]:
        last_merged_meeting_start, last_merged_meeting_end = merged_meetings[-1]

        print(str(current_meeting_start) + " " + str( current_meeting_end))
        print(str(last_merged_meeting_start) + " " + str(last_merged_meeting_end))

        # If the current meeting overlaps with the last merged meeting, use the
        # later end time of the two
        if (current_meeting_start <= last_merged_meeting_end):
            merged_meetings[-1] = (last_merged_meeting_start,
                                   max(last_merged_meeting_end,
                                       current_meeting_end))
        else:
            # Add the current meeting since it doesn't overlap
            merged_meetings.append((current_meeting_start, current_meeting_end))

    return merged_meetings

meetings = [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
#meetings =  [(1, 10), (2, 6), (3, 5), (7, 9)]
print(merged_mEEETings(meetings))