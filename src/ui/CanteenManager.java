/*

 * CanteenManager.java
 *
 * Created on __DATE__, __TIME__
 */

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import data.CanteenInfo;
import database.JDBC;
import store.DataChangeListener;
import store.DataChangeManager;

/**
 *
 * @author  __USER__
 */
public class CanteenManager extends javax.swing.JFrame implements
		DataChangeListener {

	private static final long serialVersionUID = -1657369539469931464L;
	private boolean mIsLogin = false;
	public static String mCanteenPhone;

	/** Creates new form CanteenManager */
	public CanteenManager() {
		DataChangeManager.getDataManager().registerListener(this);
		System.out.println("CanteenManager");
		initComponents();
		initMyData();
	}

	private void initMyData() {
		jTable1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				final int r = jTable1.rowAtPoint(me.getPoint());
				final int c = jTable1.columnAtPoint(me.getPoint());
				if(c>0)
					return;
				if(SwingUtilities.isRightMouseButton(me)){
					
				}else if(SwingUtilities.isLeftMouseButton(me)){
					Object obj = jTable1.getValueAt(r, 0);
					if(obj == null)
						return;
					final String id = obj.toString();
					if(id.equals(""))
						return;
					
					System.out.println("id="+id);
					final JPopupMenu pm = new JPopupMenu();
					JMenuItem item1 = new JMenuItem("ȷ�϶���");
					item1.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(JDBC.modifyOrderStatus(id, "��ȷ��") > 0){
								jTable1.setValueAt("��ȷ��", r, c+1);
							}
						}
						
					});
					JMenuItem item2 = new JMenuItem("ȷ������");
					item2.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(JDBC.modifyOrderStatus(id, "������") > 0){
								jTable1.setValueAt("������", r, c+1);
							}
						}						
					});
					pm.add(item1);
					pm.addSeparator();
					pm.add(item2);
	                pm.show(me.getComponent(), me.getX(), me.getY());
				}
			}
		});
		jTable1.setModel(mTableModal);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

		jDialog1 = new javax.swing.JDialog();
		jDialog2 = new javax.swing.JDialog();
		jPanel1 = new javax.swing.JPanel();
		jToolBar1 = new javax.swing.JToolBar();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane5 = new javax.swing.JScrollPane();
		jTextPane4 = new javax.swing.JTextPane();
		jButton5 = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(
				jDialog2.getContentPane());
		jDialog2.getContentPane().setLayout(jDialog2Layout);
		jDialog2Layout.setHorizontalGroup(jDialog2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog2Layout.setVerticalGroup(jDialog2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u9910\u5385\u7ba1\u7406\u7cfb\u7edf");
		setBackground(new java.awt.Color(204, 255, 204));

		org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings
				.createAutoBinding(
						org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
						jButton1, org.jdesktop.beansbinding.ELProperty
								.create("${background.blue}"), this,
						org.jdesktop.beansbinding.BeanProperty
								.create("graphics"));
		bindingGroup.addBinding(binding);

		jPanel1.setBackground(new java.awt.Color(204, 255, 204));

		jToolBar1.setBackground(new java.awt.Color(153, 204, 255));

		jButton1.setBackground(new java.awt.Color(153, 204, 255));
		jButton1.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton1.setText("\u5173\u4e8e");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jToolBar1.add(jButton1);

		jButton2.setBackground(new java.awt.Color(153, 204, 255));
		jButton2.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton2.setText("\u7248\u672c");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});
		jToolBar1.add(jButton2);

		jButton3.setBackground(new java.awt.Color(153, 204, 255));
		jButton3.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton3.setText("\u5e2e\u52a9");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton3MouseClicked(evt);
			}
		});
		jToolBar1.add(jButton3);

		jButton4.setBackground(new java.awt.Color(153, 204, 255));
		jButton4.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton4.setText("\u6ce8\u9500");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton4MouseClicked(evt);
			}
		});
		jToolBar1.add(jButton4);

		jButton6.setBackground(new java.awt.Color(153, 204, 255));
		jButton6.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton6.setText("\u4fee\u6539\u5bc6\u7801");
		jButton6.setFocusable(false);
		jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton6MouseClicked(evt);
			}
		});
		jToolBar1.add(jButton6);

		jTable1.setBackground(new java.awt.Color(204, 255, 204));
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jTable1);

		jLabel1.setBackground(new java.awt.Color(255, 255, 102));
		jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 18));

		jLabel3.setBackground(new java.awt.Color(255, 255, 102));
		jLabel3.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel3.setText("\u5e97\u5bb6\u540d\u5b57");

		jLabel4.setBackground(new java.awt.Color(255, 255, 102));
		jLabel4.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel4.setText("\u5e97\u5bb6\u5bc6\u7801");

		jScrollPane5.setViewportView(jTextPane4);

		jButton5.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jButton5.setText("\u767b\u5f55");
		jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton5MouseClicked(evt);
			}
		});
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												475,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								348,
																								Short.MAX_VALUE)
																						.addComponent(
																								jToolBar1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel3,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				226,
																																				Short.MAX_VALUE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel4,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				208,
																																				Short.MAX_VALUE)
																																		.addGap(23,
																																				23,
																																				23)))
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jPasswordField1,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																116,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jScrollPane5,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																117,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(17,
																				17,
																				17)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				338,
																				Short.MAX_VALUE)))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																jPasswordField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jButton5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jToolBar1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												37,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(81, 81, 81)
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												207, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		bindingGroup.bind();

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		new ModifyPassword().setVisible(true);
	}

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		if (mIsLogin) {
			jButton4.setText("�Ѿ�ע��");
			mIsLogin = false;
			jButton5.setText("��¼");
			jLabel1.setText("���¼~~~");
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:

		String phone = jTextPane4.getText();
		String password = jPasswordField1.getText();
		System.out.println("" + phone + "  " + password);
		boolean b = JDBC.queryCanteenAccountPassword(phone, password) == 1;
		if (b) {
			CanteenInfo tempCanteenInfo = JDBC.getCanteenInfo(phone);
			String str = "<html>" + "����:" + tempCanteenInfo.getName() + "<br>"
					+ "�绰:" + tempCanteenInfo.getPhone() + "<br>" + "Latitude:"
					+ tempCanteenInfo.getLatitude() + "<br>" + "Longitude:"
					+ tempCanteenInfo.getLongitude() + "<br>" + "</html>";
			jLabel1.setText(str);
			jButton5.setText("�Ѿ���¼");
			jButton4.setText("ע��");
			mCanteenPhone = tempCanteenInfo.getPhone();
			mIsLogin = true;
		}
	}

	private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		HelpDialog a = new HelpDialog(this, true);
		a.show();
	}

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		Version a = new Version(this, true);
		a.show();
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		AboutDialog a = new AboutDialog(this, true);
		a.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				getManager().setVisible(true);
			}
		});
	}

	private static CanteenManager manager = new CanteenManager();

	public static CanteenManager getManager() {
		return manager;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JDialog jDialog2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextPane jTextPane4;
	private javax.swing.JToolBar jToolBar1;
	private org.jdesktop.beansbinding.BindingGroup bindingGroup;
	// End of variables declaration//GEN-END:variables

	private javax.swing.table.DefaultTableModel mTableModal = new javax.swing.table.DefaultTableModel(
			null, new String[] { "����ID", "״̬", "�ܼ۸�", "ʳ������", "����", "�۸�" });

	@Override
	public void DataIseart() {
		System.out.println("Debug DataIseart");
		String preOrderId = "";
		String orderId, name, status;
		double price, sumPrice = 0;
		int num;
		int row = 0;
		JSONArray list = JDBC.getOrderList(mCanteenPhone);
		System.out.println("Json="+list);
		for (int i = 0; i < list.size(); i++) {                                           
			JSONObject jsonObject = (JSONObject) list.get(i);
			orderId = (String) jsonObject.get("orderId");
			System.out.println("orderId = " + orderId);
			name = (String) jsonObject.get("foodName");
			status = (String) jsonObject.get("status");
			price = (Double) jsonObject.get("price");
			num = (Integer) jsonObject.get("num");

			sumPrice += num * price;

			if (!orderId.equals(preOrderId)) {
				mTableModal.addRow(new String[] { orderId, status, "", name,
						String.valueOf(num), String.valueOf(price) });
				mTableModal.setValueAt(sumPrice, row, 2);
				sumPrice = 0;
				preOrderId = orderId;
				row = i;
			} else {
				mTableModal.addRow(new String[] { "", "", "", name,
						String.valueOf(num), String.valueOf(price) });
			}
		}
		mTableModal.setValueAt(sumPrice, row, 2);
		System.out.println("out");
	}

	@Override
	public void DataUpdate() {

	}

	@Override
	public void DataDelete() {
		// TODO Auto-generated method stub
	}

}