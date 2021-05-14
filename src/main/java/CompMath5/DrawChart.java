package CompMath5;

import javax.swing.*;

import CompMath5.Computations.Functions;
import CompMath5.Computations.LagrangeMethod;
import CompMath5.Computations.NewtonMethod;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class DrawChart {
    public void drawLagrange(double[][] points, int nf) {
        Functions f = new Functions();
        LagrangeMethod lagrangeMethod = new LagrangeMethod();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesReal = new XYSeries("Real");
        XYSeries seriesLagrange = new XYSeries("Lagrange");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < points[0].length; i++) {
            seriesPoints.add(points[0][i], points[1][i]);
        }
        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesReal.add(i, f.f(i, nf));
        }

        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesLagrange.add(i, lagrangeMethod.getCountValue(points, i));
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesReal);
        dataset.addSeries(seriesLagrange);

        JFreeChart chart = ChartFactory.createXYLineChart("Лагранж", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public void drawLagrange(double[][] points) {
        LagrangeMethod lagrangeMethod = new LagrangeMethod();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesLagrange = new XYSeries("Lagrange");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < points[0].length; i++) {
            seriesPoints.add(points[0][i], points[1][i]);
        }

        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesLagrange.add(i, lagrangeMethod.getCountValue(points, i));
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesLagrange);

        JFreeChart chart = ChartFactory.createXYLineChart("Лагранж", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public void drawNewton(double[][] points, int nf) {
        Functions f = new Functions();
        NewtonMethod newtonMethod = new NewtonMethod();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesReal = new XYSeries("Real");
        XYSeries seriesNewton = new XYSeries("Newton");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < points[0].length; i++) {
            seriesPoints.add(points[0][i], points[1][i]);
        }
        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesReal.add(i, f.f(i, nf));
        }

        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesNewton.add(i, newtonMethod.getCountValue(points, i));
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesReal);
        dataset.addSeries(seriesNewton);

        JFreeChart chart = ChartFactory.createXYLineChart("Ньютон", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public void drawNewton(double[][] points) {
        NewtonMethod newtonMethod = new NewtonMethod();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesNewton = new XYSeries("Newton");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < points[0].length; i++) {
            seriesPoints.add(points[0][i], points[1][i]);
        }

        for (double i = points[0][0]; i <= points[0][points[0].length - 1]; i += 0.1) {
            seriesNewton.add(i, newtonMethod.getCountValue(points, i));
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesNewton);

        JFreeChart chart = ChartFactory.createXYLineChart("Ньютон", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
