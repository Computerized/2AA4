## @file test_All.py
#  @author Alan Scott
#  @brief Test file
#  @date 16/02/21
#  @details This file tests the output of each function against the expected value.
#           This is done using pytest, which keeps track of the cases that pass and fail.

import pytest
from CircleT import CircleT
from TriangleT import TriangleT

circle = CircleT(1.0, 10.0, 0.5, 1.0)

def test_circle_cmx():
    assert circle.cm_x() == 1.0

def test_circle_cmy():
    assert circle.cm_y() == 10.0

def test_circle_mass():
    assert circle.mass() == 1.0

def test_circle_inert():
    assert circle.m_inert() == (1.0*0.5**2)/2

triangle = TriangleT(1.0, -10.0, 5, 17.5)

def test_triangle_cmx():
    assert triangle.cm_x() == 1.0

def test_triangle_cmy():
    assert triangle.cm_y() == -10.0

def test_triangle_mass():
    assert triangle.mass() == 17.5

def test_triangle_inert():
    assert triangle.m_inert() == (17.5*5**2)/12

def test_triangle_except():
    with pytest.raises(ValueError):
        TriangleT(1,1,-1,-1)







