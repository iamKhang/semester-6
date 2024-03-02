package leHoangKhangJsonTK1;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Project> projects = getListOfProjects();
		System.out.println("Danh sach ca du an doc tu file: ");
		for (Project project : projects) {
			System.out.println(project);
		}
		
		writeTofile(projects);
		
		System.out.println("Danh sach ca du an doc tu file da ghi: ");
		List<Project> projectsTestWrite = testWrite();
		for (Project project : projectsTestWrite) {
			System.out.println(project);
		}
		
	}

	public static List<Project> getListOfProjects() {
		return ConvertJson.readFile("data/projects.json");
	}
	
	public static List<Project> testWrite() {
		return ConvertJson.readFile("data/LeHoangKhang_21083791.json");
	}
	
	public static void writeTofile(List<Project> list) {
		ConvertJson.writeFile("data/LeHoangKhang_21083791.json", list);
	}
}
