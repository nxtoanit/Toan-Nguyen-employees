package employees;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;

public class WorkedTogether {
	@CsvBindByPosition(position = 0)
    private int empId;

    @CsvBindByPosition(position = 1)
    private int projectId;

    @CsvBindByPosition(position = 2)
    private LocalDate dateFrom;

    @CsvBindByPosition(position = 3)
    private LocalDate dateTo;

	public WorkedTogether(int empId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
		super();
		this.empId = empId;
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
}
