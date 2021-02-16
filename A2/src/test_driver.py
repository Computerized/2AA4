## @file test_All.py
#  @author Alan Scott
#  @brief Test file
#  @date 16/02/21
#  @details This file tests the output of each function against the expected value.
#           This is done using pytest, which keeps track of the cases that pass and fail.
#           To run this program, type "pytest test_driver.py" in the terminal.

import pytest
from CircleT import CircleT
from TriangleT import TriangleT
from BodyT import BodyT
from Scene import Scene

circle = CircleT(1.0, 10.0, 0.5, 1.0)

def test_circle_cmx():
    assert circle.cm_x() == 1.0

def test_circle_cmy():
    assert circle.cm_y() == 10.0

def test_circle_mass():
    assert circle.mass() == 1.0

def test_circle_inert():
    assert circle.m_inert() == (1.0*0.5**2)/2

def test_circle_except():
    with pytest.raises(ValueError):
        CircleT(1,1,-1,-1)

###############################################################

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

############################################################

body1 = BodyT([1,2,3],[3,2,1],[2,2,2])

def test_body_cmx():
    assert body1.cm_x() == 2.0

def test_body_cmy():
    assert body1.cm_y() == 2.0

def test_body_mass():
    assert body1.mass() == 6.0

def test_body_inert():
    assert body1.m_inert() == 400.0

def test_body_cm():
    assert body1.cm([1,-1,1],[2,1,2]) == 0.6

def test_body_cm_except():
    with pytest.raises(IndexError):
        body1.cm([1,2,3],[2,1,-1,2])

def test_body_mmom():
    assert body1.mmom([1,2,3],[2,1,2],[2,0,1]) == 23.0

def test_body_mmom_except():
    with pytest.raises(IndexError):
        body1.mmom([1,2,3],[2,2],[2,0,1])

def test_body_except_length():
    with pytest.raises(ValueError):
        BodyT([1,2,3],[3],[2,2,2])

def test_body_except_mass():
    with pytest.raises(ValueError):
        BodyT([1,2,3],[3,3,3],[2,-1,2])

###############################################

circle2 = CircleT(0,0,3,2)
scene1 = Scene(circle2, 3, 4, 1, 0)

def test_scene_getshape():
    assert (scene1.get_shape().cm_x() == circle2.cm_x() and scene1.get_shape().cm_y() == circle2.cm_y()
    and scene1.get_shape().mass() == circle2.mass() and scene1.get_shape().m_inert() == circle2.m_inert())

def test_scene_getforces():
    a,b = scene1.get_unbal_forces()
    assert a == 3 and b == 4

def test_scene_getvelos():
    a,b = scene1.get_init_velo()
    assert a == 1 and b == 0

def test_scene_setshape():
    triangle = TriangleT(1,1,1,1)
    scene1.set_shape(triangle)
    assert scene1.get_shape() == triangle

def test_scene_setforces():
    scene1.set_unbal_forces(-1,2)
    a,b = scene1.get_unbal_forces()
    assert a == -1 and b == 2

def test_scene_setvelos():
    scene1.set_init_velo(1,-2)
    a,b = scene1.get_init_velo()
    assert a == 1 and b == -2

def closeEnough(xcalc,xtrue,e):
    return abs(xcalc-xtrue)/abs(xtrue) < e

def test_scene_sim():
    a,b = scene1.sim(1,10)
    assert closeEnough(a[1],1/9,10**(-4)) and closeEnough(a[9],1.0,10**(-4))

def test_scene_sim_zero():
    with pytest.raises(ZeroDivisionError):
        scene1.sim(1,1)

