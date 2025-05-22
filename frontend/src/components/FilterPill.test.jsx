import { render, screen } from '@testing-library/react'
import FilterPill from './FilterPill'

test('Should render a Pill with text "Favoritos"', () => {
     render(<FilterPill text={"Favoritos"}/>)
     expect(screen.getByText("Favoritos")).toBeInTheDocument()
})
