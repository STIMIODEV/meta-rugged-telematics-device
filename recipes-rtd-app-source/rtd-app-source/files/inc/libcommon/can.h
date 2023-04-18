#ifndef CAN_H
#define CAN_H

#include <linux/can.h>

int can_init(const char *, int);
int can_fd_init(int bitrate, int dbitrate, int txqueuelen);
int set_can_mask_and_filter(uint32_t *mask, uint32_t *filter, int no_of_filter);
int can_write(char *, char *);
int can_read(char *, struct canfd_frame *);
int can_deinit(const char *);

#endif /* CAN_H */
