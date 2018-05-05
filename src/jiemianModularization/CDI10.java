package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import testJDialog.JDialogCDI7;

/**
 * 注销VIP
 * @author Junking
 *
 */
public class CDI10 extends CDI{
	JLabel jl;
	JTextField jtf;
	SQL sql;
	private JButton jb ;
	
	CDI10(){
		
		jl = new JLabel("    请输入你要删除VIP的编号:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("删除");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = new SQL("VIP");
			
				//判断是否为数字并且判断是否过长
					if(!new IsNums().isNumeric(jtf.getText())&&jtf.getText().length()<=11&&jtf.getText().length()>=0)
					{					
						JOptionPane.showMessageDialog(null, "请输入正确格式的VIP编号", "查询有误", JOptionPane.CLOSED_OPTION, null);
						return;
					}
					
					PreparedStatement psql;
					//预处理删除数据
					try {
						psql = sql.con.prepareStatement("delete from VIP where id = ?");
						psql.setString(1, jtf.getText());
						psql.executeUpdate();
						psql.close();
						JOptionPane.showMessageDialog(null, "删除成功");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				
			}
		});
		
		
		
		jl.setSize(500,50 );
		jtf.setSize(350, 40);
		jb.setSize(100, 40);
		
		jl.setLocation(xRealCenter(jl), 100);
		jtf.setLocation(xRealCenter(jtf), 200);
		jb.setLocation(xRealCenter(jb), 300);
		
		
		this.add(jtf);
		this.add(jl);
		this.add(jb);
	
		
		this.setBackground(Color.YELLOW);
		
		
	}
	
}
