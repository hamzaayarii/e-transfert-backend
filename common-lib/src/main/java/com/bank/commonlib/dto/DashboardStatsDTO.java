package com.bank.commonlib.dto;


public class DashboardStatsDTO {

    private int usersCount;
    private int appointmentsCount;
    private int transfersCount;
    private int notificationsCount;

    public DashboardStatsDTO() {}

    public DashboardStatsDTO(int usersCount, int appointmentsCount, int transfersCount, int notificationsCount) {
        this.usersCount = usersCount;
        this.appointmentsCount = appointmentsCount;
        this.transfersCount = transfersCount;
        this.notificationsCount = notificationsCount;
    }

    // Getters et setters

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getAppointmentsCount() {
        return appointmentsCount;
    }

    public void setAppointmentsCount(int appointmentsCount) {
        this.appointmentsCount = appointmentsCount;
    }

    public int getTransfersCount() {
        return transfersCount;
    }

    public void setTransfersCount(int transfersCount) {
        this.transfersCount = transfersCount;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }

    public void setNotificationsCount(int notificationsCount) {
        this.notificationsCount = notificationsCount;
    }
}
