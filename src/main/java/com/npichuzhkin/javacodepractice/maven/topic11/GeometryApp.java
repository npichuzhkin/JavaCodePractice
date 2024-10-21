package com.npichuzhkin.javacodepractice.maven.topic11;

import com.pichuzhkin.geometrylibrary.twodimensionalfigures.Circle;
import com.pichuzhkin.geometrylibrary.twodimensionalfigures.Rectangle;
import com.pichuzhkin.geometrylibrary.twodimensionalfigures.Triangle;
import com.pichuzhkin.geometryutils.GeometryUtils;
import com.pichuzhkin.threedimensionalshapes.Cube;
import com.pichuzhkin.threedimensionalshapes.Sphere;

public class GeometryApp {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,10);
        Rectangle rectangle2 = new Rectangle(20,20);
        Triangle triangle = new Triangle(5,5,5);
        Circle circle = new Circle(30);

        Cube cube = new Cube(15);
        Sphere sphere = new Sphere(40);

        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter() +
                "\nПериметр треугольника: " + triangle.getPerimeter() +
                "\nПлощадь прямоугольника: " + rectangle.getArea() +
                "\nПлощадь треугольника: " + triangle.getArea() +
                "\nПлощадь круга: " + circle.getArea() +
                "\nДлина круга: " + circle.getCircumference());

        System.out.println(rectangle + "\n" +
                triangle + "\n" +
                circle + "\n");

        System.out.println(GeometryUtils.isLargerThan(rectangle, rectangle2));
        System.out.println(GeometryUtils.isLessThan(rectangle,rectangle2));

        System.out.println(cube);
        System.out.println(sphere);

        System.out.println(sphere.isPointInside(1,2,4));
    }
}
