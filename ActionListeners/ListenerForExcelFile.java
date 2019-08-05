package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import FrameListStudentMain.*;
import Panels.PanelForUser;

public class ListenerForExcelFile implements ActionListener {
	private ListOfStudents list;
	private PanelForUser p;

	public ListenerForExcelFile(ListOfStudents list, PanelForUser p) {
		this.list = list;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser = new JFileChooser();
		int retval = fileChooser.showSaveDialog(p.getExcel());
		if (retval == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (file == null) {
				return;
			}
			if (!file.getName().toLowerCase().endsWith(".xlsx")) {
				file = new File(file.getParentFile(), file.getName() + ".xlsx");
			}

			try {
				FileOutputStream out = new FileOutputStream(file);
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("Students");

				CellStyle style = wb.createCellStyle();
				HSSFFont font = wb.createFont();
				font.setBold(true);
				font.setItalic(true);
				font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
				style.setFont(font);

				Row heading = sheet.createRow(0);
				heading.createCell(0).setCellValue("First name");
				heading.createCell(1).setCellValue("Last name");
				heading.createCell(2).setCellValue("Index number");
				heading.createCell(3).setCellValue("Level of studies");
				heading.createCell(4).setCellValue("Year of studies");
				heading.getCell(0).setCellStyle(style);
				heading.getCell(1).setCellStyle(style);
				heading.getCell(2).setCellStyle(style);
				heading.getCell(3).setCellStyle(style);
				heading.getCell(4).setCellStyle(style);

				Row row;

				int i = 1;
				int j = 0;
				for (Node tmp = list.head; tmp != null; tmp = tmp.next) {
					row = sheet.createRow(i);
					row.createCell(j).setCellValue(tmp.info.getFirstName());
					sheet.autoSizeColumn(j);
					row.createCell(j + 1).setCellValue(tmp.info.getLastName());
					sheet.autoSizeColumn(j + 1);
					row.createCell(j + 2).setCellValue(Double.parseDouble(tmp.info.getIndexNumber()));
					sheet.autoSizeColumn(j + 2);
					row.createCell(j + 3).setCellValue(tmp.info.getLevelOfStudies());
					sheet.autoSizeColumn(j + 3);
					row.createCell(j + 4).setCellValue(Double.parseDouble(tmp.info.getYearOfStudies()));
					sheet.autoSizeColumn(j + 4);
					i++;
					j = 0;
				}

				wb.write(out);
				out.close();
				wb.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "You saved this list!", "Notification", 1);

		}
	}
}
