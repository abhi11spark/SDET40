package org.tyss.ProvidenceSMS.genericUtility;

public enum TabNames {
	DASHBOARDTAB("Dashboard"), MYPROFILETAB("My Profile"), CLASSROOMTAB("Classroom"), GRADETAB("Grade"), SUBJECTTAB("Subject"),
	STUDENTTAB("Student"), STUDENTPAYMENTTAB("Student Payment"), ATTENDANCETAB("Attendance"), EXAM("Exam"),PETTYCASHTAB("Petty Cash");

	private String tabName;

	private TabNames(String tabName) {
		this.tabName = tabName;
	}

	public String getTabName() {
		return tabName;
	}

}
