package array;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.sun.jna.FromNativeContext;

public class Test {
	
//	public static void main(String[] args) {
//		long a = System.currentTimeMillis();
////		List<GatherDatas> ss = new ArrayList<>();
////		for (int i = 0; i < 10000; i++) {
////			String fileName = "C:\\Users\\Administrator\\Documents\\aaaa.data";
////			GatherDatas d = getInstance().readGatherDatas(fileName);
////			ss.add(d);
////		}
//		String fileName = "C:\\Windows\\System32\\";
//		File f = new File(fileName);
//		if (f.exists()) {
//			File[] fs = f.listFiles();
//			Arrays.sort(fs, new Comparator<File>() {
//				public int compare(File f1, File f2) {
//					long diff = f1.lastModified() - f2.lastModified();
//					if (diff > 0)
//						return 1;
//					else if (diff == 0)
//						return 0;
//					else
//						return -1;
//				}
//			});
//			for (int i = fs.length - 1; i > -1; i--) {
//				System.out.println(fs[i].getName());
//				System.out.println(new Date(fs[i].lastModified()));
//			}
//		}
//		long b = System.currentTimeMillis();
//		System.out.println((b - a));
//	}

	public static void main(String[] args) {
		
//		double[][][] datas = new double[2][21][1] {
//			1.1, 0.0, 0.8, -0.7, 0.7, -0.1, 0.6, -0.5, 0.4, -0.4, 1.1, 0.5, 0.4, 0.2, 0.9, 0.9, 1.0, 1.0, 0.5, 0.6, 0.5, 0.7, 0.5, 0.2, 1.2, 1.4, 1.1, 1.1,
//			1.8, 1.9, 1.6, 1.0, 1.8, 0.7, 1.8, 0.7, 1.7, 0.8, 2.7, 1.8, 2.3, 1.7
//		};
		double[] data = new double[] { 
				1.1, 0.0, 0.8, -0.7, 0.7, -0.1, 0.6, -0.5, 0.4, -0.4, 1.1, 0.5, 0.4, 0.2, 0.9,
				0.9, 1.0, 1.0, 0.5, 0.6, 0.5, 0.7, 0.5, 0.2, 1.2, 1.4, 1.1, 1.1, 1.8, 1.9, 1.6, 1.0, 1.8, 0.7, 1.8, 0.7,
				1.7, 0.8, 2.7, 1.8, 2.3, 1.7, 
				0.6, -0.4, 0.6, -1.0, 0.4, -0.6, 0.6, -0.6, 0.4, -0.6, 1.0, 0.6, 0.2, 0.0,
				0.6, 0.9, 0.7, 0.5, 0.4, 0.3, 0.5, 0.7, 0.3, 0.4, 1.0, 1.4, 1.2, 1.3, 1.5, 1.9, 1.7, 0.9, 1.5, 0.6, 1.2,
				0.5, 1.3, 0.7, 2.3, 1.9, 2.4, 1.7,
				0.3, -0.7, 0.2, -1.3, 0.3, -1.2, 0.8, -0.8, 0.3, -0.7, 0.3, 0.6, -0.4, 0.2, 0.2, 0.5, 0.5, 0.3, 0.5,
				0.2, 0.5, 0.5, 0.0, 0.3, 0.8, 1.2, 0.6, 1.0, 1.4, 1.6, 1.6, 1.0, 1.4, 0.6, 1.3, 0.4, 1.1, 0.4, 2.2, 1.3,
				1.7, 1.2 
				}; 
		int xLength = 2;
		int yLength = 21;
		int zLength = 3;
		
		double[][][] datas = new double[xLength][yLength][zLength];
		for (int i = 0; i < data.length; i++) {
			int x = i % xLength == 0 ? 0 : 1;
			int y = (i % (xLength * yLength)) / xLength;
			int z = i / (xLength * yLength/* * zLength*/);
			datas[x][y][z] = data[i];
//			System.out.println("datas[" + x + "][" + y + "][" + z + "] = " + datas[x][y][z]);
		}
//		System.out.println(datas.length);
//		System.out.println(datas[datas.length - 1].length);
//		System.out.println(datas[datas.length - 1][datas[datas.length - 1].length - 1].length);
//		System.out.println("------------------");
//		for (int i = 0; i < datas.length; i++) {
//			for (int j = 0; j < datas[i].length; j++) {
//				for (int k = 0; k < datas[i][j].length; k++) {
//					System.out.println("datas[" + i + "][" + j + "][" + k + "] = " + datas[i][j][k]);
//				}
//			}
//		}
		// 单向平均位置偏差
		double[][] XiAvg = new double[xLength][yLength];
		// 标准不确定度
		double[][] Si = new double[xLength][yLength];
		// 2倍标准不确定度
		double[][] Si2 = new double[xLength][yLength];
		// 4倍标准不确定度 Ri 单向重复定位精度
		double[][] Si4 = new double[xLength][yLength];
		// 单向平均位置偏差 - 2倍标准不确定度
		double[][] XiSubSi2 = new double[xLength][yLength];
		// 单向平均位置偏差 + 2倍标准不确定度
		double[][] XiAddSi2 = new double[xLength][yLength];
		// 反向差值
		double[] Bi = new double[yLength];
		// 双向重复定位精度
		double[] Ri = new double[yLength];
		// 双向平均位置偏差
		double[] Xi = new double[yLength];
		// 定位系统偏差
		double[] E = new double[xLength];
		// 重复定位精度
		double[] R = new double[xLength];
		// 定位精度
		double[] A = new double[xLength];
		// 定位系统偏差
		double EAvg = 0;
		// 重复定位精度
		double RAvg = 0;
		// 定位精度
		double AAvg = 0;
		// 反向差值
		double B = 0;
		// 平均反向差值
		double BAvg = 0;
		// 双向平均位置偏差的范围
		double M = 0;
		
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				double d = 0;
				for (int k = 0; k < datas[i][j].length; k++) {
					d = d + datas[i][j][k];
//					System.out.println("datas[" + i + "][" + j + "][" + k + "] = " + datas[i][j][k]);
				}
				XiAvg[i][j] = formatValue(d / zLength);
//				System.out.println("XiAvg[" + i + "][" + j + "] = " + XiAvg[i][j]);
				d = 0;
				for (int k = 0; k < datas[i][j].length; k++) {
					d = d + Math.pow(datas[i][j][k] - XiAvg[i][j], 2);
//					System.out.println("datas[" + i + "][" + j + "][" + k + "] = " + datas[i][j][k]);
				}
				d = zLength > 1 ? Math.sqrt(d / (zLength - 1)) : 0;
				Si[i][j] = formatValue(d);
				Si2[i][j] = formatValue(d * 2);
				Si4[i][j] = formatValue(d * 4);
				XiSubSi2[i][j] = formatValue(XiAvg[i][j] - Si2[i][j]);
				XiAddSi2[i][j] = formatValue(XiAvg[i][j] + Si2[i][j]);
//				System.out.println("Si[" + i + "][" + j + "] = " + Si[i][j]);
//				System.out.println("Si2[" + i + "][" + j + "] = " + Si2[i][j]);
//				System.out.println("Si4[" + i + "][" + j + "] = " + Si4[i][j]);
//				System.out.println("XiSubSi2[" + i + "][" + j + "] = " + XiSubSi2[i][j]);
			}
		}
//		double maxB = 0;
		double sumB = 0, maxX = 0, minX = 0;
		for (int j = 0; j < yLength; j++) {
			double d = 0;
			Bi[j] = formatValue(XiAvg[1][j] - XiAvg[0][j]);
//			System.out.println("Bi[" + j + "] = " + Bi[j]);
			B = Math.max(Math.abs(Bi[j]), B);
			sumB += Bi[j];
			d = Math.max(Math.max(Si4[0][j], Si4[1][j]), Si2[0][j] + Si2[1][j] + Math.abs(Bi[j]));
			Ri[j] = formatValue(d);
//			System.out.println("Ri[" + j + "] = " + Ri[j]);
			RAvg = Math.max(Ri[j], RAvg);
			d = (XiAvg[1][j] + XiAvg[0][j]) / 2.0;
			Xi[j] = formatValue(d);
//			System.out.println("Xi[" + j + "] = " + Xi[j]);
			maxX = Math.max(Xi[j], maxX);
			minX = Math.min(Xi[j], minX);
		}
//		System.out.println("RAvg: " + RAvg);
//		System.out.println("B: " + B);
		BAvg = formatValue(sumB / yLength);
//		System.out.println("BAvg: " + BAvg);
		M = maxX - minX;
		System.out.println("M: " + M);
		
		double maxE = 0, minE = 0, maxA = 0, minA = 0;
		for (int i = 0; i < xLength; i++) {
			double maxEi = 0, minEi = 0, maxRi = 0, maxAi = 0, minAi = 0;
			for (int j = 0; j < yLength; j++) {
				maxEi = Math.max(XiAvg[i][j], maxEi);
				minEi = Math.min(XiAvg[i][j], minEi);
				maxRi = Math.max(Si4[i][j], maxRi);
				maxAi = Math.max(XiAvg[i][j] + Si2[i][j], maxAi);
				minAi = Math.min(XiAvg[i][j] - Si2[i][j], minAi);
			}
			maxE = Math.max(maxEi, maxE);
			minE = Math.min(minEi, minE);
			maxA = Math.max(maxAi, maxA);
			minA = Math.min(minAi, minA);
//			double d = maxE - min;
			E[i] = formatValue(maxEi - minEi);
//			System.out.println("E[" + i + "] = " + E[i]);
			R[i] = formatValue(maxRi);
//			System.out.println("R[" + i + "] = " + R[i]);
			A[i] = formatValue(maxAi - minAi);
//			System.out.println("A[" + i + "] = " + A[i]);
		}
		EAvg = maxE - minE;
//		System.out.println("EAvg: " + EAvg);
		AAvg = maxA - minA;
//		System.out.println("AAvg: " + AAvg);
	}
	
	private static double formatValue(Double d) {
		int prec = 2;
		BigDecimal v = new BigDecimal(d).setScale(prec, RoundingMode.HALF_UP);
		return v.doubleValue();
	}
}
