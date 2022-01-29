package justacommonguy.guiutils;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/** 
 * Utilities for Swing.
 * Contains static methods that perform basic setup of Swing components.
 * The static fields are custom values that I tend to use for my GUIs.
*/
public final class SwingUtils {

	/**
	 * Contains the HOME path of the user. Targets the Desktop in a Windows OS.
	 */
	public static final String HOME_PATH = 
			FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();

	/**
	 * This is a utility class. No instances should be created.
	 */
	private SwingUtils() {}

	/**
	 * Basic <code>JFrame</code> setup. Frame is set to visible.
	 * 
	 * @param frame frame to be modified.
	 * @param width width of the frame.
	 * @param height height of the frame.
	 * @param defaultOperation operation executed when the frame is closed.
	 * @param isResizable whether the frame should be resizable.
	 */
	public static void setUpJFrame(JFrame frame, int width, int height, 
			int defaultOperation, boolean isResizable) {

		frame.setDefaultCloseOperation(defaultOperation);
		frame.setSize(width, height);
		frame.setResizable(isResizable);
		frame.setVisible(true);
	}

	/**
	 * Basic <code>JFrame</code> setup.
	 * Frame closes on exit and is resizable. Frame is set to visible.
	 * 
	 * @param frame frame to be modified.
	 * @param width width of the frame.
	 * @param height height of the frame.
	 */
	public static void setUpJFrame(JFrame frame, int width, int height) {
		setUpJFrame(frame, width, height, JFrame.EXIT_ON_CLOSE, true);
	}

	/**
	 * Minimizes the <code>Frame</code> and opens it again so it is moved to the front.
	 * 
	 * @param frame the frame to be brought to the top.
	 */
	public static void frameToFront(Frame frame) {
		int s = frame.getExtendedState();
		frame.setExtendedState(JFrame.ICONIFIED);
		frame.setExtendedState(s);
	}

	/**
	 * Sets several values to the <code>GridBagConstraints</code> provided.
	 * Only useful to save lines of code.
	 * 
	 * @param gbc <code>GridBagConstraints</code> whose values will be modified.
	 * @param fill whether the components should be resized or not and how.
	 * @param gridx horizontal cell of the grid.
	 * @param gridy vertical cell of the grid.
	 * @param ipadx horizontal size of the component.
	 * @param ipady vertical size of the component.
	 * @param insets <code>Insets</code> which define padding.
	 */
	public static void setGridBagConstraintsValues(GridBagConstraints gbc, int anchor, int fill, 
			int gridx, int gridy, int ipadx, int ipady, Insets insets) {

		gbc.anchor = anchor;
		gbc.insets = insets;
		gbc.fill = fill;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.ipadx = ipadx;
		gbc. ipady = ipady;
	}

	/**
	 * Sets several values to the <code>GridBagConstraints</code> provided.
	 * Components will not be resized.
	 * Only useful to save lines of code.
	 * 
	 * @param gbc <code>GridBagConstraints</code> whose values will be modified.
	 * @param gridx horizontal cell of the grid.
	 * @param gridy vertical cell of the grid.
	 * @param ipadx horizontal size of the component.
	 * @param ipady vertical size of the component.
	 * @param insets <code>Insets</code> which define padding.
	 */
	public static void setGridBagConstraintsValues(GridBagConstraints gbc, int gridx, int gridy, 
			int ipadx, int ipady, Insets insets) {
		setGridBagConstraintsValues(gbc, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				gridx, gridy, ipadx, ipady, insets);
	}

	/**
	 * Sets several values to the <code>GridBagConstraints</code> provided.
	 * Components will not be resized.
	 * External padding is set to <code>new Insets(0, 0, 0, 0)</code>.
	 * Only useful to save lines of code.
	 * 
	 * @param gbc <code>GridBagConstraints</code> whose values will be modified.
	 * @param gridx horizontal cell of the grid.
	 * @param gridy vertical cell of the grid.
	 * @param ipadx horizontal size of the component.
	 * @param ipady vertical size of the component.
	 */
	public static void setGridBagConstraintsValues(GridBagConstraints gbc, int gridx, int gridy, 
			int ipadx, int ipady) {
		setGridBagConstraintsValues(gbc, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				gridx, gridy, ipadx, ipady, new Insets(0, 0, 0, 0));
	}

	/**
	 * Makes a <code>JMenuItem</code> with an <code>ActionListener</code> and a keyboard shortcut.
	 * 
	 * @param text text of the button.
	 * @param l <code>ActionListener</code> to be called.
	 * @param k <code>Keystroke</code> for the keyboard shortcut.
	 * 
	 * @return <code>JMenuItem</code> created.
	 */
	public static JMenuItem makeMenuItem(String text, ActionListener l, KeyStroke k) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.addActionListener(l);
		menuItem.setAccelerator(k);

		return menuItem;
	}

	/**
	 * Makes a basic <code>JTextField</code>.
	 * 
	 * @param columns number of columns of the field.
	 * @param f font of the field.
	 * @param isEditable whether the user can edit the text or not.
	 * @param alignment the alignment of the field text.
	 * 
	 * @return <code>JTextField</code> created.
	 */
	public static JTextField makeTextField(int columns, Font f, boolean isEditable, int alignment) {
		JTextField field = new JTextField(columns);
		field.setFont(f);
		field.setEditable(isEditable);
		field.setHorizontalAlignment(alignment);

		return field;
	}

	/**
	 * Makes a basic <code>JTextField</code>.
	 * The field is editable and the text is aligned to the left.
	 * 
	 * @param columns number of columns of the field.
	 * @param f font of the field.
	 * 
	 * @return <code>JTextField</code> created.
	 */
	public static JTextField makeTextField(int columns, Font f) {
		return makeTextField(columns, f, true, JTextField.LEFT);
	}

	/**
	 * Makes a basic <code>JScrollPane</code> with a <code>JTextArea</code>.
	 * 
	 * @param box the text area to be included.
	 * @param f the font of the text area.
	 * @param verticalPolicy the vertical scrollbar policy of the text area.
	 * @param horizontalPolicy the horizontal scrollbar policy of the text area.
	 * @param isEditable whether the user can edit the text or not.
	 * 
	 * @return <code>JScrollPane</code> created.
	*/
	public static JScrollPane makeTextArea(JTextArea box, Font f, 
			int verticalPolicy, int horizontalPolicy, boolean isEditable) {
		
		box.setLineWrap(true);
		box.setWrapStyleWord(true);
		box.setFont(f);
		box.setEditable(isEditable);
		JScrollPane scroller = new JScrollPane(box);
		scroller.setVerticalScrollBarPolicy(verticalPolicy);
		scroller.setHorizontalScrollBarPolicy(horizontalPolicy);

		return scroller;
	}

	/**
	 * Makes a basic <code>JScrollPane</code> with a <code>JTextArea</code>.
	 * Vertical scrollbar policy is set to 
	 * 	<code>ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED</code> 
	 * 	and <code>ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER</code>.
	 * Text is editable by default.
	 * 
	 * @param box the text area to be included.
	 * @param f the font of the text area.
	 * 
	 * @return <code>JScrollPane</code> created.
	 */
	public static JScrollPane makeTextArea(JTextArea box, Font f) {
		return makeTextArea(box, f, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, true);
	}

	/**
	 * Makes a basic <code>JScrollPane</code> with a <code>JTextArea</code>.
	 * Vertical scrollbar policy is set to 
	 * 	<code>ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED</code> 
	 * 	and <code>ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER</code>.
	 * 
	 * @param box the text area to be included.
	 * @param f the font of the text area.
	 * @param isEditable whether the user can edit the text or not.
	 * 
	 * @return <code>JScrollPane</code> created.
	 */
	public static JScrollPane makeTextArea(JTextArea box, Font f, boolean isEditable) {
		return makeTextArea(box, f, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, isEditable);
	}

	/**
	 * Creates and shows a save file dialog using <code>JFileChooser</code>.
	 * The file selected will be set with a default extension.
	 * 
	 * @param initialDir the directory opened by default.
	 * @param defaultFileName default selected file. Extension must not be included.
	 * @param defaultExtension default extension of the default selected file and the file saved. 
	 * 	<code>.</code> must be included.
	 * @param parent parent component of the <code>JFileChooser</code>.
	 * @param filters extension filters to check the file saved.
	 * 
	 * @return <code>JFileChooser</code> created. 
	 * Returns <code>null</code> when the dialog is cancelled or closed.
	 */
	public static JFileChooser makeSaveFileChooser(String initialDir, String defaultFileName, 
			String defaultExtension, Component parent, FileNameExtensionFilter... filters) {
		
		JFileChooser saver = new JFileChooser(initialDir);
		addFiltersToChooser(saver, filters);
		saver.setSelectedFile(new File(saver.getCurrentDirectory().toString() + File.separator + 
				defaultFileName + defaultExtension));

		if (saver.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
			File f = saver.getSelectedFile();

			for (FileNameExtensionFilter fil : filters) {
				if (!fil.accept(f)) {
					f = new File(f.toString() + defaultExtension);
				}
			}

			saver.setSelectedFile(f);
			return saver;
		}

		return null;
	}

	/**
	 * Creates and shows an open file dialog using <code>JFileChooser</code>.
	 * 
	 * @param initialDir the directory opened by default.
	 * @param parent parent component of the <code>JFileChooser</code>.
	 * @param filters extension filters to check the file opened.
	 * 
	 * @return <code>JFileChooser</code> created. 
	 * Returns <code>null</code> when the dialog is cancelled or closed.
	 */
	public static JFileChooser makeOpenFileChooser(String initialDir, Component parent, 
		FileNameExtensionFilter... filters) {
		
		JFileChooser opener = new JFileChooser(initialDir);
		addFiltersToChooser(opener, filters);
		
		return ((opener.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) ? opener : null);
	}

	/**
	 * Adds extension filters to the <code>JFileChooser</code> specified. 
	 * The first filter of the array will be set to the default extension.
	 * 
	 * @param chooser the <code>JFileChooser</code> to be added the filters.
	 * @param filters filters to add.
	 */
	public static void addFiltersToChooser(JFileChooser chooser, FileNameExtensionFilter[] filters) {
		chooser.setFileFilter(filters[0]);
		for (FileNameExtensionFilter fil : filters) {
			chooser.addChoosableFileFilter(fil);
		}
	}
}
