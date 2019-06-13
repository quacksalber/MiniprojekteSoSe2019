package MP4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;

/**
 * A simple java application to edit configuration
 * files that can be read and written from and to 
 * a file.
 * 
 * @author Marcus
 */
public class JEditor extends JFrame {

	/**
	 * The serialization version.
	 */
	private static final long serialVersionUID = 6303550117468605423L;
	/**
	 * The table model to show the data in a table.
	 */
	private JEditorModel model = new JEditorModel(new MultiHashMap<>());
	/**
	 * The table that shows the data using the model.
	 */
	private JTable table = new JTable(model);
	/**
	 * The add button in the toolbar.
	 */
	private JButton add = new JButton(" + ");
	/**
	 * The remove button in the toolbar.
	 */
	private JButton remove = new JButton(" - ");
	
	/**
	 * Creates a new editor.
	 */
	public JEditor() {
		super("Java Configuration File Editor");
		// create a menu bar with a file menu (shown at the top of the window)
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu file = new JMenu("File");
		// setup mnemonic to be able to use ALT+F to open the file menu
		file.setMnemonic(KeyEvent.VK_F); 
		menubar.add(file);
		// add a load action
		JMenuItem load = new JMenuItem("Load ...", KeyEvent.VK_L);
		file.setToolTipText("Load from file");
		file.add(load);
		load.addActionListener(event->onLoad(event));
		// add a save action
		JMenuItem save = new JMenuItem("Save ...", KeyEvent.VK_S);
		save.setToolTipText("Save to file");
		file.add(save);
		save.addActionListener(event->onSave(event));
		// add a seperator and an exit action
		file.add(new JSeparator(SwingConstants.HORIZONTAL));
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
		exit.setToolTipText("Exit the application");
		file.add(exit);
		exit.addActionListener(event->System.exit(0));
		// add a jtable as the main content inside a scroll pane
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		// add a toolbar below the menu bar
		JToolBar toolbar = new JToolBar(SwingConstants.HORIZONTAL);
		toolbar.setFloatable(false);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		// add the + button to the toolbar.
		add.setMnemonic(KeyEvent.VK_PLUS);
		add.setToolTipText("Add a new key-value pair.");
		add.addActionListener(event->onAdd(event));
		toolbar.add(add);
		// add the - button to the toolbar
		remove.setMnemonic(KeyEvent.VK_MINUS);
		add.setToolTipText("Remove selected key-value pair.");
		remove.addActionListener(event->onRemove(event));
		remove.setEnabled(false);
		toolbar.add(remove);
		// hook up a selection listener to enable/disable the - button
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(e->onSelectionChanged(e));
		
	}
	
	/**
	 * Called when the selection of the table changes. This
	 * will update the button state of the remove button so
	 * that it is only enabled when a row is selected.
	 * 
	 * @param e The selection event, ignored.
	 */
	private void onSelectionChanged(ListSelectionEvent e) {
		int row = table.getSelectedRow();
		remove.setEnabled(row != -1);
	}

	/**
	 * Called when the add button has been pressed.
	 * 
	 * @param event The event.
	 */
	private void onAdd(ActionEvent event) {
		JEditorDialog.KeyValueResult r = JEditorDialog.showKeyValueDialog("Add an entry", "", "");
		if (r.ok) {
			model.getData().addValue(r.key, r.value);
			model.fireTableDataChanged();
		}
	}

	/**
	 * Called when the load menu item is pressed. This should load
	 * the data from the file and set the local variable as well
	 * as the table model.
	 * 
	 * @param event The event, ignored.
	 */
	private void onLoad(ActionEvent event) {
		JEditorDialog.FileResult result = JEditorDialog.showOpenFileDialog();
		if (result.ok) {
			model.setData(loadFromFile(result.file));
		}
	}
	
	/**
	 * Loads a configuration file. If not successful, this method
	 * should return a new empty map.
	 * 
	 * @param inputFile The input file.
	 * @return The map that has been loaded from the file or
	 * 	a new map, if an IOException occurs during loading.
	 */
	private MultiMap<String, String> loadFromFile(File inputFile) {
		// TODO: implement
		return null;
	}
	
	
	/**
	 * Called when the save menu item is selected. Saves the current data to a file.
	 * 
	 * @param event The event, ignored.
	 */
	private void onSave(ActionEvent event) {
		JEditorDialog.FileResult result = JEditorDialog.showSaveFileDialog();
		if (result.ok) {
			saveToFile(result.file, model.getData());
		}
	}
	
	/**
	 * Saves the data to the output file.
	 * 
	 * @param data The data to save.
	 * @param outputFile The file to write to.
	 */
	private void saveToFile(File outputFile, MultiMap<String, String> data) {
		// TODO: implement
	}
	
	
	/**
	 * Removes the row from the table that is currently
	 * selected.
	 * 
	 * @param event The event.
	 */
	private void onRemove(ActionEvent event) {
		int row = table.getSelectedRow();
		if (row != -1) {
			String key = (String)model.getValueAt(row, 0);
			String value = (String)model.getValueAt(row, 1);
			try {
				model.getData().removeValue(key, value);				
			} catch (KeyNotFoundException e) {
				throw new RuntimeException("Bug in multi map.", e);
			}
			model.fireTableDataChanged();
		}
	}
	
	
	/**
	 * Runs the editor application.
	 * 
	 * @param args Ignored.
	 */
	public static void main(String[] args) {
		JEditor editor = new JEditor();
		editor.setDefaultCloseOperation(EXIT_ON_CLOSE);
		editor.setSize(new Dimension(600, 400));
		editor.setVisible(true);
	}
	
	
}
