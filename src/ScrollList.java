/*
 *  Assignment: Java6 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Scroll list to be used in SimControls to display new vehicles
 */

import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ScrollList extends JScrollPane{
        public JList<String> scrollList;


        public ScrollList(String[] list) {
                /* create new JScrollPane to allow for scrolling w/in list */
                scrollList = new JList<String>(list);
                new JScrollPane();
                scrollList.setLayoutOrientation(JList.VERTICAL);
                scrollList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                scrollList.setVisibleRowCount(-1);
                setPreferredSize(new Dimension(200, 25));
                setViewportView(scrollList);
        }
}
