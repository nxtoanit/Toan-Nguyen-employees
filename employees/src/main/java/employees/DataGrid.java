package employees;

public class DataGrid {

	private int empIdOne;
    
    private int empIdTwo;

  	private int projectId;
    
    private long daysWorked;
    
    public DataGrid(int empIdOne, int empIdTwo, int projectId, long daysWorked) {
		super();
		this.empIdOne = empIdOne;
		this.empIdTwo = empIdTwo;
		this.projectId = projectId;
		this.daysWorked = daysWorked;
	}
    
    public int getEmpIdOne() {
		return empIdOne;
	}

	public void setEmpIdOne(int empIdOne) {
		this.empIdOne = empIdOne;
	}

	public int getEmpIdTwo() {
		return empIdTwo;
	}

	public void setEmpIdTwo(int empIdTwo) {
		this.empIdTwo = empIdTwo;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public long getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(long daysWorked) {
		this.daysWorked = daysWorked;
	}
}
